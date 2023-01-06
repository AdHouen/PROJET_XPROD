package com.xprod.spring.xprod.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name="PRODUITAPPRO")
public class ProduitAppro extends Produit{
	
	@Column(name = "PRIXACHATUNITAIREHTMO")
	private Long prixAchatUnitaireHTMoyen;
	@Column(name = "REFEXTERNEPRODUIT")
	private String refExterneProduit;
	@Column(name = "REFAPPROHTPRODUIT")
	private double prixApproHTProduit;
	
	
	public Long getPrixAchatUnitaireHTMoyen() {
		return prixAchatUnitaireHTMoyen;
	}
	public String getRefExterneProduit() {
		return refExterneProduit;
	}
	public double getPrixApproHTProduit() {
		return prixApproHTProduit;
	}
	public void setPrixAchatUnitaireHTMoyen(Long prixAchatUnitaireHTMoyen) {
		this.prixAchatUnitaireHTMoyen = prixAchatUnitaireHTMoyen;
	}
	public void setRefExterneProduit(String refExterneProduit) {
		this.refExterneProduit = refExterneProduit;
	}
	public void setPrixApproHTProduit(double prixApproHTProduit) {
		this.prixApproHTProduit = prixApproHTProduit;
	}
	public ProduitAppro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProduitAppro(Long idProduit, String refInterneProduit, String designationProduit, String descriptifProduit,
			double prixVenteUProduit) {
		super(idProduit, refInterneProduit, designationProduit, descriptifProduit, prixVenteUProduit);
		// TODO Auto-generated constructor stub
	}
	public ProduitAppro(Long idProduit, String refInterneProduit, String designationProduit, String descriptifProduit,
			double prixVenteUProduit, Long prixAchatUnitaireHTMoyen, String refExterneProduit,
			double prixApproHTProduit) {
		super(idProduit, refInterneProduit, designationProduit, descriptifProduit, prixVenteUProduit);
		this.prixAchatUnitaireHTMoyen = prixAchatUnitaireHTMoyen;
		this.refExterneProduit = refExterneProduit;
		this.prixApproHTProduit = prixApproHTProduit;
	}
	
	

	

}
