package com.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneLivraison implements Serializable {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name ="id_produit")
	private Produit produit;
	@ManyToOne
	@JoinColumn(name="id_livraison")
	private Livraison livraison;
	private int quantite;
	public LigneLivraison() {
		super();
	}
	public LigneLivraison(Livraison livraison,Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.livraison = livraison;
		this.quantite = quantite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Livraison getLivraison() {
		return livraison;
	}
	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
