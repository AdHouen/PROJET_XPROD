export class Produit {
  public idProduit: number
  public refInterneProduit: string;
  public designationProduit: string;
  public descriptifProduit: string;
  public prixVenteUProduit: number;
  public imgProduit:string;
  constructor() {
    this.idProduit = 0;
    this.refInterneProduit = "";
    this.designationProduit = "";
    this.descriptifProduit = "";
    this.prixVenteUProduit = 0;
    this.imgProduit="";
  }
}
