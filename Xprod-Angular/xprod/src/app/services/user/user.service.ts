import { CustomHttpResponse } from './../../models/custom-http-response/custom-http-response';
import { User } from './../../models/user/user';
import { HttpClient, HttpErrorResponse, HttpEvent, HttpResponse } from '@angular/common/http';
import { AppSettings } from 'src/app/settings/app.settings';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private host : string = AppSettings.APP_URL;
  private loggedInUsername: string;

  constructor(private http: HttpClient) {
    this.loggedInUsername ="";
   }


  // Find all users
  public getUsers() :Observable <User[] | HttpErrorResponse >{
    return this.http.get<User[]>(`${this.host}/user/list`);
  }

  // Ajouter un Utilisateur
  public addUsers(formData : FormData) :Observable <User | HttpErrorResponse >{
    return this.http.post<User>(`${this.host}/user/add`, formData);
  }

  // Edit un utilisateur
  public updateUsers(formData : FormData) :Observable <User | HttpErrorResponse >{
    return this.http.put<User>(`${this.host}/user/update`, formData);
  }

  // Reset password
  public resetPassword(email : string) :Observable <any | HttpErrorResponse >{
    return this.http.get(`${this.host}/user/resetpassword/${email}`);
  }

  // Supprimer un utilisateur
  public deleteUsers(userId : number) :Observable <CustomHttpResponse | HttpErrorResponse >{
    return this.http.delete<CustomHttpResponse>(`${this.host}/user/delete/${userId}`);
  }

  // Enregistrer l'utilisateur dans le cache local
  public addUsersToLocalCache(users : User[]) : void{
     localStorage.setItem('users',JSON.stringify(users));
  }

  // Je récupère un utilisateur dans le cache local
  public getUserFromLocalCache() : User{
    return JSON.stringify(localStorage.getItem('users')) as any;
  }

  public createUserFormDate(loggedInUsername: string, user : User, profileImage:File) : FormData{
  const formData = new FormData();
  formData.append('currentUsername',loggedInUsername);
  formData.append('firstName',user.firstName);
  formData.append('lastName',user.lastName);
  formData.append('username',user.username);
  formData.append('email',user.email);
  formData.append('role',user.role);
  formData.append('profileImage',profileImage);
  formData.append('isActive',JSON.stringify(user.isActive));
  formData.append('isNotLocked',JSON.stringify(user.isNotLocked));
  return formData;

  }



}
