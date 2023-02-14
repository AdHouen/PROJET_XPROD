import { User } from './../../models/user/user';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { AppSettings } from 'src/app/settings/app.settings';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public host : string = AppSettings.APP_URL;
  private token : string;
  private loggedInUsername: string;
  private jwtHelper = new JwtHelperService();

  constructor(private http:HttpClient)
    {
      this.token ="";
      this.loggedInUsername ="";


   }
  public login(user:User) : Observable<HttpResponse<any> | HttpErrorResponse>{

    return this.http.post<HttpResponse<any> | HttpErrorResponse>(
      `${this.host}/user/login`, user , {observe: 'response'}
    );
  }

  public register(user:User) : Observable<HttpResponse<any> | HttpErrorResponse>{

    return this.http.post<HttpResponse<any> | HttpErrorResponse>(
      `${this.host}/user/register`, user , {observe: 'response'}
    );
  }

  public logOut() : void{

    this.token = "";
    this.loggedInUsername = "";
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    localStorage.removeItem('users');
  }
  // J'enregistre le token dans le cache local
  public saveToken(token: string) : void{
    this.token = token;
    localStorage.setItem('token', token);
  }

  // J'ajoute mon utilisateur dans le cache local
  public addUserToLocalCache(user:User) : void{

    // On stringify puisque sinon 'user' n'est pas un string
    localStorage.setItem('user', JSON.stringify(user) );
  }

  // Je récupère un utilisateur dans le cache local
  public getUserFromLocalCache() : User{
    return JSON.stringify(localStorage.getItem('user')) as any;
  }

  // Je téléchage le token du cache local
  public loadToken() : void{
    this.token = localStorage.getItem('token') as string;
  }

  // Je récupére le token téléchargé
  public getToken() : string{
    return this.token;
  }

  // Vérifier que l'utilisateur est connecté
  public isLoggedIn() : boolean{
    this.loadToken(); // Je charge le token
    if (this.token != null && this.token !== '') {
      // Décode le token en enlevant le "bearer"
      if (this.jwtHelper.decodeToken(this.token).sub != null || '') {
        // Vérifier que le token n'est pas expiré
        if (!this.jwtHelper.isTokenExpired(this.token)) {
          // Je récupére l'utilisateur connecté
          this.loggedInUsername = this.jwtHelper.decodeToken(this.token).sub;
          return true;
        }
      }

    } else {
      this.logOut();
      return false;
    }

    return false;
  }


}
