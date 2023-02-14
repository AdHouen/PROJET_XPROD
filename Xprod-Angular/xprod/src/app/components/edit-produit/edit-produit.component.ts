import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitService } from './../../services/produit/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css']
})
export class EditProduitComponent implements OnInit {
  declare editForm : FormGroup;

  constructor(
    private produitService : ProduitService,
    private router : Router,
    private route : ActivatedRoute,
    private formBuilder : FormBuilder,

  ){


  }
  ngOnInit(): void {
    this.editForm = this.formBuilder.group({
      idProduit: ['', Validators.required],
      refInterneProduit: ['', Validators.required],
      designationProduit: ['', Validators.required],
      descriptifProduit: ['', Validators.required],
      prixVenteUProduit: ['', Validators.required],
      imgProduit : ['', Validators.required],
    });

    const idProduit = Number(this.route.snapshot.paramMap.get('idProduit')) ;
    this.produitService.editProduit(idProduit).subscribe(
      data => {
        this.editForm.setValue(data);

      }

    )
  }
  update(){
    console.log(this.editForm.value);
    if (this.editForm.valid) {
      this.produitService.updateProduit(this.editForm.value).subscribe(
        () => {
          this.router.navigate(['/produit']);
        }
      );

    }

  }

}

