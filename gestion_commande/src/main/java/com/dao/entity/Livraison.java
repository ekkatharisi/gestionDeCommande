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
public class Livraison implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	//a : accepted // r : refused
	private String status;
	private String dateLivraison;
	@OneToMany(mappedBy="livraison")
	private Collection<LigneLivraison> ligneLivraison;
	@ManyToOne
	@JoinColumn(name="id_fournisseur")
	private Fournisseur fournisseur;
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="id_commande")
	private Commande commande;
	
	public Livraison() {
		super();
	}
	public Livraison(Collection<LigneLivraison> ligneLivraison,
			Fournisseur fournisseur, Compte compte) {
		super();
		this.ligneLivraison = ligneLivraison;
		this.fournisseur = fournisseur;
		this.compte = compte;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<LigneLivraison> getLigneLivraison() {
		return ligneLivraison;
	}
	public void setLigneLivraison(Collection<LigneLivraison> ligneLivraison) {
		this.ligneLivraison = ligneLivraison;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public String getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	} 
	
	

}
