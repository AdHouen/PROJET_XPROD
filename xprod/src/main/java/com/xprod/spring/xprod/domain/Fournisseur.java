package com.xprod.spring.xprod.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="FOURNISSEUR")
public class Fournisseur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDFOURNISSEUR")
	private Long idHournisseur;
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
	
	
	public Long getIdHournisseur() {
		return idHournisseur;
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
	public void setIdHournisseur(Long idHournisseur) {
		this.idHournisseur = idHournisseur;
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
	public Fournisseur(Long idHournisseur, String nomFournisseur, String raisonSocialeFournisseur,
			String rueAdresseFournisseur, String codePostalAdresseFournisseur, String villeAdresseFournisseur,
			String paysAdresseFournisseur, String emailFournisseur, String telFournisseur, String refExterneProduit,
			double prixApproHTProduit) {
		super();
		this.idHournisseur = idHournisseur;
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
	}
	public Fournisseur() {
		super();
	}
	
	
	

}
