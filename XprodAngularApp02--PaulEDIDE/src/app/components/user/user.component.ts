import { CustomHttpResponse } from 'src/app/models/custom-http-response';
import { HttpErrorResponse } from '@angular/common/http';
import { NotificationType } from './../../enum/notification-type.enum';
import { NotificationService } from 'src/app/services/notification/notification.service';
import { UserService } from './../../services/user/user.service';
import { Component, OnInit } from '@angular/core';
import { BehaviorSubject, Subscription } from 'rxjs';
import { User } from 'src/app/models/user/user';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


  private titleSubject = new BehaviorSubject<string>('Users');
  public titleAction$ = this.titleSubject.asObservable();
  declare public refreshing: boolean;
  declare public users : User[];
  private subscription : Subscription[]=[];
  declare public selectedUser: User | null;
  declare public fileName: string;
  declare public profileImage: File;
  public editUser = new User() ;
  declare public currentUsername: string;
  declare user : User;


  constructor(
    private userService : UserService,
    private notificationService : NotificationService
    ) {

  }
  ngOnInit(): void {
    this.getUsers(true);
  }

  public changeTitle(title : string) : void {
    this.titleSubject.next(title);
  }

  public getUsers(showNotification : boolean) : void {
    this.refreshing = true;
    this.subscription.push(
      this.userService.getUsers().subscribe(
        (data : User[]) => {
          this.userService.addUsersToLocalCache(data); // Ajouter la liste des utilisateurs au local storage
          this.users = data;
          this.refreshing = false;
          if (showNotification) {
            this.sendNotification(NotificationType.SUCCESS, `${data.length} Utilisateur(s) chargés avec succés`)
          }
        },
        (errorResponse: HttpErrorResponse) => {
          this.sendNotification(NotificationType.ERROR, errorResponse.error.message);
          this.refreshing = false;
      }

      )
    );
  }
  // Button qui permet de voir les infos de l'utilisateur
  public onSelectUser(selectedUser :User) : void {
    this.selectedUser = selectedUser;
    this.clickButton('openUserInfo');

  }
  // Méthode pour récupérer le nom et l'image
  public onProfileImageChange(fileName : string, profileImage : File ):void{
    // console.log(fileName, profileImage);
    this.fileName = fileName;
    this.profileImage = profileImage;



  }


  // Méthode pour ajouter un nouvel utilisateur
  public onAddNewUser(userForm:NgForm):void{
   const formData = this.userService.createUserFormData(null as any,userForm.value,this.profileImage);
   this.subscription.push(
    this.userService.addUser(formData).subscribe(
      (data : User) => {
        this.clickButton('new-user-close');
        this.getUsers(false);
        this.fileName = null as any;
        this.profileImage = null as any;
        userForm.reset();
        this.sendNotification(NotificationType.SUCCESS, `${data.firstname} ${data.lastname} a été ajouté avec succes`)
      },
      (errorResponse: HttpErrorResponse) => {
        this.sendNotification(NotificationType.ERROR, errorResponse.error.message);
        this.profileImage= null as any;
    }
    )
   )
  }
// Button qui permet de sauvgarder
  saveNewUser() {
    this.clickButton('new-user-save');
    }

// Méthode qui permet de rechercher parmis les utilisateurs
  public searchUsers(searchTerm:string): void {
    // console.log(searchTerm);

    const results : User[] = [];
    for(const user of this.userService.getUsersFromLocalCache()){
      if (user.firstname.toLocaleLowerCase().indexOf(searchTerm.toLowerCase())!== -1 ||
          user.lastname.toLocaleLowerCase().indexOf(searchTerm.toLowerCase())!== -1 ||
          user.username.toLocaleLowerCase().indexOf(searchTerm.toLowerCase())!== -1 ||
          user.userId.toLocaleLowerCase().indexOf(searchTerm.toLowerCase())!== -1
      ) {
        results.push(user);
      }
    }
    this.users  = results;
    if (results.length === 0 || !searchTerm) {
      this.users = this.userService.getUsersFromLocalCache()
    }

  }

  // Méthode pour éditer un utilisateur
  public onEditUser(editUser : User) {
    this.editUser = editUser;
    this.currentUsername =editUser.username;
    this.clickButton('openUserEdit');
  }

  // Méthode pour sauvegarder l'édit  d'un utilisateur
  public onUpdateUser(): void {
    const formData = this.userService.createUserFormData(this.currentUsername,this.editUser,this.profileImage);
   this.subscription.push(
    this.userService.updateUser(formData).subscribe(
      (data : User) => {
        this.clickButton('closeEditUserModalButton');
        this.getUsers(false);
        this.fileName = null as any;
        this.profileImage = null as any;
        this.sendNotification(NotificationType.SUCCESS, `${data.firstname} ${data.lastname} a été édité avec succes`)
      },
      (errorResponse: HttpErrorResponse) => {
        this.sendNotification(NotificationType.ERROR, errorResponse.error.message);
        this.profileImage= null as any;
      }
    )
   )
  }

  // Méthode pour delete un User
  public onDeleteUser(userId : number): void {
    this.subscription.push(
      this.userService.deleteUser(userId).subscribe(
        (data :CustomHttpResponse) => {
          this.sendNotification(NotificationType.SUCCESS, `L'utilisateur a bien été supprimé avec succes`);
          this.getUsers(true);
        },
        (errorResponse: HttpErrorResponse) => {
          this.sendNotification(NotificationType.ERROR, errorResponse.error.message);
        }
      )
    )

  }

  // Méthode pour reset le password
  public onResetPassword(emailForm:NgForm): void {
    this.refreshing = true;
    const emailAdresse = emailForm.value['reset-password-email'];
    this.subscription.push(
      this.userService.resetPassword(emailAdresse).subscribe(
        (data :CustomHttpResponse) => {
          this.sendNotification(NotificationType.SUCCESS, `Le password a bien été réinitialisé`);
          this.refreshing = false;
        },
        (errorResponse: HttpErrorResponse) => {
          this.sendNotification(NotificationType.WARNING, errorResponse.error.message);
          this.refreshing = false;
        },
        () => emailForm.reset()
      )

    );

  }

  // Méthode générale pour le click des boutons
  private clickButton(buttonId : string): void{
    document.getElementById(buttonId)?.click();
  }

  // Méthode pour les notifications
  private sendNotification(notificationType: NotificationType, message: string) {
    if(message){
      this.notificationService.notify(notificationType, message);
    } else {
      this.notificationService.notify(notificationType, 'Une erreur est survenue. Veuillez réessayer.');
    }
  }






}
