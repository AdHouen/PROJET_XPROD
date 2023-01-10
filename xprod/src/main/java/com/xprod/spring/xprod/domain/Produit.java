package com.xprod.spring.xprod.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity 
@Table(name="PRODUIT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Produit implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPRODUIT")
	private Long idProduit;
	
	@Column(name = "REFINTERNE")
	private String refInterneProduit;
	@Column(name = "DESIGNATION")
	private String designationProduit;
	@Column(name = "DESCRIPTIF")
	private String descriptifProduit;
	@Column(name = "PRIXVENTEHT")
	private double prixVenteUProduit;
	
	public Long getIdProduit() {
		return idProduit;
	}
	
	
	public String getRefInterneProduit() {
		return refInterneProduit; 
	}
	public String getDesignationProduit() {
		return designationProduit;
	}
	public String getDescriptifProduit() {
		return descriptifProduit;
	}
	public double getPrixVenteUProduit() {
		return prixVenteUProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public void setRefInterneProduit(String refInterneProduit) {
		this.refInterneProduit = refInterneProduit;
	}
	public void setDesignationProduit(String designationProduit) {
		this.designationProduit = designationProduit;
	}
	public void setDescriptifProduit(String descriptifProduit) {
		this.descriptifProduit = descriptifProduit;
	}
	public void setPrixVenteUProduit(double prixVenteUProduit) {
		this.prixVenteUProduit = prixVenteUProduit;
	}
	public Produit(Long idProduit, String refInterneProduit, String designationProduit, String descriptifProduit,
			double prixVenteUProduit) {
		super();
		this.idProduit = idProduit;
		this.refInterneProduit = refInterneProduit;
		this.designationProduit = designationProduit;
		this.descriptifProduit = descriptifProduit;
		this.prixVenteUProduit = prixVenteUProduit;
	}


	public Produit() {
		super();
	}
	

	
	
	

}
