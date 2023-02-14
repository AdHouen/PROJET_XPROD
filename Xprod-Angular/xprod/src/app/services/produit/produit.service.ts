import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppSettings } from 'src/app/settings/app.settings';
import { Produit } from 'src/app/models/produit/produit';


@Injectable({
  providedIn: 'root'
})


export class ProduitService {
  httpOptions = {
    headers : new HttpHeaders ({'Content-Type' :'application/json'})
  }

  constructor(private http:HttpClient) { }

  findAllProduits(){
    return this.http.get(AppSettings.APP_URL+"/produits")
  }

  saveProduit(produit:Produit){
    return this.http.post(AppSettings.APP_URL+"/produits", JSON.stringify(produit),this.httpOptions);

  }

  editProduit(idProduit:number) {
    return this.http.get(AppSettings.APP_URL+"/produits/"+idProduit)

  }

  updateProduit(produit:Produit){
    return this.http.put(AppSettings.APP_URL+"/produits/" + produit.idProduit, JSON.stringify(produit),this.httpOptions);
    //return this.http.put(AppSettings.APP_URL+"/produits", JSON.stringify(produit),this.httpOptions);
  }

  deleteProduit(idProduit : number){
    return this.http.delete(AppSettings.APP_URL+"/produits/"+idProduit)

  }
}
