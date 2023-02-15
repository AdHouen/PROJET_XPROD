import { UserComponent } from './components/user/user/user.component';
import { RegisterComponent } from './components/register/register/register.component';
import { LoginComponent } from './components/login/login/login.component';
import { NotificationService } from './services/notification/notification.service';
import { NotificationModule } from './notification.module';
import { AuthenticationGuard } from './guard/authentication.guard';
import { AuthInterceptor } from './auth.interceptor';
import { UserService } from './services/user/user.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProduitComponent } from './components/produit/produit.component';
import { AddProduitComponent } from './components/add-produit/add-produit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListProduitComponent } from './components/list-produit/list-produit.component';
import { EditProduitComponent } from './components/edit-produit/edit-produit.component';
import { AuthenticationService } from './services/authentication/authentication.service';

@NgModule({
  declarations: [
    AppComponent,
    ProduitComponent,
    AddProduitComponent,
    ListProduitComponent,
    EditProduitComponent,
    LoginComponent,
    RegisterComponent,
    UserComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NotificationModule

  ],
  providers: [
    NotificationService,
    AuthenticationGuard,
    AuthenticationService,
    UserService,
    {provide : HTTP_INTERCEPTORS,useClass: AuthInterceptor, multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
