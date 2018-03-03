package com.dao.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String  dateCommande;
	@ManyToOne
	@JoinColumn(name = "id_fournisseur")
	private Fournisseur fournisseur;
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> ligneCommande;
	@ManyToOne
	@JoinColumn(name = "id_Compte")
	private Compte compte;

	public Commande(Fournisseur fournisseur,
			Collection<LigneCommande> ligneCommande, Compte compte) {
		super();
		this.fournisseur = fournisseur;
		this.ligneCommande = ligneCommande;
		this.compte = compte;
	}

	public Commande() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Collection<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(Collection<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

}
