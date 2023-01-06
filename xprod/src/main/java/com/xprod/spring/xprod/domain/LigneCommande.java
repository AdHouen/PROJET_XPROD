package com.xprod.spring.xprod.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="LIGNECOMMANDE")
public class LigneCommande implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDLIGNECOMMANDE")
	private Long idLigneCommande;
	@Column(name = "LIGNECOMMANDE")
	private int ligneCommande;
	@Column(name = "DATELIVRAISONLIGNECOMMANDE")
	private LocalDate dateLivraisonLigneCommande;
	@Column(name = "PRIXUNITAIREHTLIGNECOMMANDE")
	private double prixUnitaireHTLigneCommande;
	public Long getIdLigneCommande() {
		return idLigneCommande;
	}
	
	public int getLigneCommande() {
		return ligneCommande;
	}
	public LocalDate getDateLivraisonLigneCommande() {
		return dateLivraisonLigneCommande;
	}
	public double getPrixUnitaireHTLigneCommande() {
		return prixUnitaireHTLigneCommande;
	}
	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public void setLigneCommande(int ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	public void setDateLivraisonLigneCommande(LocalDate dateLivraisonLigneCommande) {
		this.dateLivraisonLigneCommande = dateLivraisonLigneCommande;
	}
	public void setPrixUnitaireHTLigneCommande(double prixUnitaireHTLigneCommande) {
		this.prixUnitaireHTLigneCommande = prixUnitaireHTLigneCommande;
	}
	public LigneCommande(Long idLigneCommande, int ligneCommande, LocalDate dateLivraisonLigneCommande,
			double prixUnitaireHTLigneCommande) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.ligneCommande = ligneCommande;
		this.dateLivraisonLigneCommande = dateLivraisonLigneCommande;
		this.prixUnitaireHTLigneCommande = prixUnitaireHTLigneCommande;
	}
	public LigneCommande() {
		super();
	}
	
	
	
	
	

}
