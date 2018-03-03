package com.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable {
	@Id @GeneratedValue
	private Long code;
	private String nom;
	private double prix;
	@ManyToOne
	@JoinColumn(name="id_ligneCommande")
	private LigneCommande ligneCommande;
	@ManyToOne
	@JoinColumn(name="id_commande")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="id_livraison")
	private Livraison livraison;
	
	public Produit() {
		super();
	}
	
	
	public Produit(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}


	public Produit(String nom, double prix, LigneCommande ligneCommande,
			Commande commande, Livraison livraison) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.ligneCommande = ligneCommande;
		this.commande = commande;
		this.livraison = livraison;
	}

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}
	
	
}
