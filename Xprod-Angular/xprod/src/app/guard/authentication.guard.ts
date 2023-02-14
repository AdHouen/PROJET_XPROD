import { NotificationService } from './../services/notification/notification.service';
import { AuthenticationService } from './../services/authentication/authentication.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { NotificationType } from '../enum/notification-type.enum';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationGuard implements CanActivate {

  constructor(
    private authenticationService: AuthenticationService,
    private router : Router,
    private notificationService: NotificationService){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    return this.isUserLoggedIn();
  }

  private isUserLoggedIn(): boolean {
    if (this.authenticationService.isLoggedIn()) {
      this.notificationService.showNotification(NotificationType.SUCCESS,"Bravo ! ".toUpperCase()+"Vous êtes connecté :)");
      return true;
    }
    this.router.navigate(['/login']);
    this.notificationService.showNotification(NotificationType.ERROR,"Oups : ".toUpperCase()+"Veuillez vous connecter pour accéder à cette page");

    return false;

  }
}
