import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProduitService } from 'src/app/services/produit/produit.service';

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html',
  styleUrls: ['./add-produit.component.css']
})
export class AddProduitComponent implements OnInit {
  declare form : FormGroup;


  constructor (
    private produitService : ProduitService,
    private router : Router,
    private formBuilder : FormBuilder
  ){}
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      idProduit: ['', Validators.required],
      refInterneProduit: ['', Validators.required],
      designationProduit: ['', Validators.required],
      descriptifProduit: ['', Validators.required],
      prixVenteUProduit: ['', Validators.required],
      imgProduit : ['', Validators.required],
    });

}

create(){
  console.log(this.form.value);
  this.produitService.saveProduit(this.form.value).subscribe(
    () =>{
       this.router.navigate(["/produits"])
    }
  )

}
}
