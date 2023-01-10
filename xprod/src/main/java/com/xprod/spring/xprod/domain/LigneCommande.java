package com.xprod.spring.xprod.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="LIGNECOMMANDE")
public class LigneCommande implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIGNECOMMANDE_ID")
	private Long ligneCommande_id;
	@Column(name = "QTELIGNECOMMANDE")
	private int qteLigneCommande;
	@Column(name = "DATELIVRAISONLIGNECOMMANDE")
	private String dateLivraisonLigneCommande;
	@Column(name = "PRIXUNITAIREHTLIGNECOMMANDE")
	private double prixUnitaireHTLigneCommande;
	
	@ManyToOne
	@JoinColumn(name="COMMANDE_ID")
	private Commande commande;
	
	
	
	
	

}
