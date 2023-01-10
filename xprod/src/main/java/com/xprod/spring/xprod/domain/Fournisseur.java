package com.xprod.spring.xprod.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="FOURNISSEUR")
public class Fournisseur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDFOURNISSEUR")
	private Long idFournisseur;
	@Column(name = "NOMFOURNISSEUR")
	private String nomFournisseur;
	@Column(name = "RAISONSOCIALEFOURNISSEUR")
	private String raisonSocialeFournisseur;
	@Column(name = "RUEFOURNISSEUR")
	private String rueAdresseFournisseur;
	@Column(name = "CODEPOSTALFOURNISSEUR")
	private String codePostalAdresseFournisseur;
	@Column(name = "VILLEFOURNISSEUR")
	private String villeAdresseFournisseur;
	@Column(name = "PAYSFOURNISSEUR")
	private String paysAdresseFournisseur;
	@Column(name = "EMAILFOURNISSEUR")
	private String emailFournisseur;
	@Column(name = "TELFOURNISSEUR")
	private String telFournisseur;
	@Column(name = "REFEXTERNEPRODUIT")
	private String refExterneProduit;
	@Column(name = "REFAPPROHTPRODUIT")
	private double prixApproHTProduit;
	
	@OneToMany(mappedBy = "FOURNISSEUR", fetch = FetchType.LAZY)
	private List<Commande> commandes = new ArrayList<>();

	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public String getRaisonSocialeFournisseur() {
		return raisonSocialeFournisseur;
	}

	public String getRueAdresseFournisseur() {
		return rueAdresseFournisseur;
	}

	public String getCodePostalAdresseFournisseur() {
		return codePostalAdresseFournisseur;
	}

	public String getVilleAdresseFournisseur() {
		return villeAdresseFournisseur;
	}

	public String getPaysAdresseFournisseur() {
		return paysAdresseFournisseur;
	}

	public String getEmailFournisseur() {
		return emailFournisseur;
	}

	public String getTelFournisseur() {
		return telFournisseur;
	}

	public String getRefExterneProduit() {
		return refExterneProduit;
	}

	public double getPrixApproHTProduit() {
		return prixApproHTProduit;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public void setRaisonSocialeFournisseur(String raisonSocialeFournisseur) {
		this.raisonSocialeFournisseur = raisonSocialeFournisseur;
	}

	public void setRueAdresseFournisseur(String rueAdresseFournisseur) {
		this.rueAdresseFournisseur = rueAdresseFournisseur;
	}

	public void setCodePostalAdresseFournisseur(String codePostalAdresseFournisseur) {
		this.codePostalAdresseFournisseur = codePostalAdresseFournisseur;
	}

	public void setVilleAdresseFournisseur(String villeAdresseFournisseur) {
		this.villeAdresseFournisseur = villeAdresseFournisseur;
	}

	public void setPaysAdresseFournisseur(String paysAdresseFournisseur) {
		this.paysAdresseFournisseur = paysAdresseFournisseur;
	}

	public void setEmailFournisseur(String emailFournisseur) {
		this.emailFournisseur = emailFournisseur;
	}

	public void setTelFournisseur(String telFournisseur) {
		this.telFournisseur = telFournisseur;
	}

	public void setRefExterneProduit(String refExterneProduit) {
		this.refExterneProduit = refExterneProduit;
	}

	public void setPrixApproHTProduit(double prixApproHTProduit) {
		this.prixApproHTProduit = prixApproHTProduit;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Fournisseur(Long idFournisseur, String nomFournisseur, String raisonSocialeFournisseur,
			String rueAdresseFournisseur, String codePostalAdresseFournisseur, String villeAdresseFournisseur,
			String paysAdresseFournisseur, String emailFournisseur, String telFournisseur, String refExterneProduit,
			double prixApproHTProduit, List<Commande> commandes) {
		super();
		this.idFournisseur = idFournisseur;
		this.nomFournisseur = nomFournisseur;
		this.raisonSocialeFournisseur = raisonSocialeFournisseur;
		this.rueAdresseFournisseur = rueAdresseFournisseur;
		this.codePostalAdresseFournisseur = codePostalAdresseFournisseur;
		this.villeAdresseFournisseur = villeAdresseFournisseur;
		this.paysAdresseFournisseur = paysAdresseFournisseur;
		this.emailFournisseur = emailFournisseur;
		this.telFournisseur = telFournisseur;
		this.refExterneProduit = refExterneProduit;
		this.prixApproHTProduit = prixApproHTProduit;
		this.commandes = commandes;
	}

	public Fournisseur() {
		super();
	}

	
	
	
	
	
	

}
