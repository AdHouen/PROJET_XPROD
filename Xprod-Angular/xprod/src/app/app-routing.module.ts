import { UserComponent } from './components/user/user/user.component';
import { RegisterComponent } from './components/register/register/register.component';
import { LoginComponent } from './components/login/login/login.component';
import { EditProduitComponent } from './components/edit-produit/edit-produit.component';
import { ListProduitComponent } from './components/list-produit/list-produit.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitComponent } from './components/produit/produit.component';

const routes: Routes = [
  {
    path:'produit',
    component:ProduitComponent
  },{
    path : 'produit/:idProduit',
    component:ListProduitComponent
  },{
    path : 'edit/:idProduit',
    component:EditProduitComponent
  },{
    path : 'login',
    component:LoginComponent
  },{
    path : 'register',
    component:RegisterComponent
  },{
    path : 'user/management',
    component:UserComponent
  },


  {
    path : '',
    redirectTo:'login',
    pathMatch:'full',

  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
