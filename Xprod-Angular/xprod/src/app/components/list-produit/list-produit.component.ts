import { ActivatedRoute, Router } from '@angular/router';
import { ProduitService } from './../../services/produit/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css']
})
export class ListProduitComponent implements OnInit {

  declare produits: any;

  constructor(
    private produitService : ProduitService,
    private router : Router,
    private route : ActivatedRoute
  ){

  }
  ngOnInit(): void {
    this.produitService.findAllProduits().subscribe(
      data => {
        console.log(data);
        this.produits = data;


      }
    );
    if (this.route.snapshot.paramMap.get('idProduit') != null) {
      this.remove();
    }
  }

  remove() {
    const idProduit = Number(this.route.snapshot.paramMap.get('idProduit')) ;
    this.produitService.deleteProduit(idProduit).subscribe(
      () => {
        this.router.navigate(["/produit"])

      }

    )
  }

}
