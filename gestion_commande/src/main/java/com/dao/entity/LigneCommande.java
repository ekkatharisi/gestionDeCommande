package com.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne 
	@JoinColumn(name ="id_commande")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;
	private int quantite;
	public LigneCommande() {
		super();
	}
	public LigneCommande(Commande commande, Produit produit, int quantite) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
