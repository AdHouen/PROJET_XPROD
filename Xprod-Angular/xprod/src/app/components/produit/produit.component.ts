import { ProduitService } from './../../services/produit/produit.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {

  declare produits : any[];
  declare form : FormGroup;

  constructor (
    private produitService : ProduitService,
    private router : Router,
    private formBuilder : FormBuilder
  ){

  }
  ngOnInit(): void {
      this.form = this.formBuilder.group({
        refInterneProduit: ['', Validators.required],
        designationProduit: ['', Validators.required],
        descriptifProduit: ['', Validators.required],
        prixVenteUProduit: ['', Validators.required],
        imgProduit : ['', Validators.required],
    });
    this.getProduits();
  }
  getProduits() {
    this.produitService.findAllProduits().subscribe(
      data => {
        console.log(data);
        this.produits = data as any[];

      }
    );
  }
  deleteProduit(id : number) {

    return this.produitService.deleteProduit(id).subscribe(
      () => {
        this.getProduits();


      }
    )
  }


}
