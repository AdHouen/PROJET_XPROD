import { HeaderType } from './../../../enum/header-type.enum';
import { NotificationType } from './../../../enum/notification-type.enum';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { User } from './../../../models/user/user';
import { NotificationService } from './../../../services/notification/notification.service';
import { AuthenticationService } from './../../../services/authentication/authentication.service';
import { Router } from '@angular/router';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy{
  public showLoading: boolean;
  private subscriptions : Subscription[] = [];

  constructor(
    private router : Router,
    private authenticationService : AuthenticationService,
    private notificationService : NotificationService,

  ){
    this.showLoading = false;

  }

  ngOnInit(): void {
    if (this.authenticationService.isLoggedIn()) {
      this.router.navigateByUrl('/user/management');
    } else {
      this.router.navigateByUrl('/login')
    }

  }

  public onLogin(user:User) : void {
    this.showLoading = true;
    console.log(user);
    this.subscriptions.push(
      this.authenticationService.login(user).subscribe(
        (response : HttpResponse<User> | any) => {
          const token = response.headers.get(HeaderType.JWT_TOKEN);
          this.authenticationService.saveToken(token);
          this.authenticationService.addUserToLocalCache(response.body);
          this.router.navigateByUrl('/user/management');
          this.showLoading = false;

        },
        (errorResponse :HttpErrorResponse) => {
          this.sendErrorNotification(NotificationType.ERROR, errorResponse.error.message);
          this.showLoading = false;
        }

      )
    );

  }
  private sendErrorNotification(notificationType: NotificationType, message: string) {
    if (message) {
      this.notificationService.showNotification(notificationType,message);
    } else {
      this.notificationService.showNotification(notificationType,"Une erreur est survenue veuillez réessayer de nouveau");
    }
  }

  ngOnDestroy(): void {

    this.subscriptions.forEach(
      sub => sub.unsubscribe()
    );

  }


}
