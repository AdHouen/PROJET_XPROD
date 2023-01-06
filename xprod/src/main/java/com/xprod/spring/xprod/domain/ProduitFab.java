package com.xprod.spring.xprod.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUITFAB")
public class ProduitFab extends Produit {
	
	@Column(name = "NBHEUREMOYEN")
	private int nbHeuresMoyen;

	public int getNbHeuresMoyen() {
		return nbHeuresMoyen;
	}

	public void setNbHeuresMoyen(int nbHeuresMoyen) {
		this.nbHeuresMoyen = nbHeuresMoyen;
	}

	public ProduitFab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProduitFab(Long idProduit, String refInterneProduit, String designationProduit, String descriptifProduit,
			double prixVenteUProduit) {
		super(idProduit, refInterneProduit, designationProduit, descriptifProduit, prixVenteUProduit);
		// TODO Auto-generated constructor stub
	}

	public ProduitFab(Long idProduit, String refInterneProduit, String designationProduit, String descriptifProduit,
			double prixVenteUProduit, int nbHeuresMoyen) {
		super(idProduit, refInterneProduit, designationProduit, descriptifProduit, prixVenteUProduit);
		this.nbHeuresMoyen = nbHeuresMoyen;
	}
	
	

}
