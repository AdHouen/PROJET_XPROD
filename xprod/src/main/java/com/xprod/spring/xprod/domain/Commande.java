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
@Table(name="COMMANDE")
public class Commande implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDCOMMANDE")
	private Long idCommande;
	@Column(name = "DATECOMMANDE")
	private LocalDate dateCommande;
	
	
	public Long getIdCommande() {
		return idCommande;
	}
	public LocalDate getDateCommande() {
		return dateCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Commande(Long idCommande, LocalDate dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}
	public Commande() {
		super();
	}
	
	
	

}
