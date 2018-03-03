package com.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Facture implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy = "facture")
	private Collection<LigneFacture> ligneFacture;
	private double totale;
	private boolean status = false;
	@ManyToOne
	@JoinColumn(name = "id_fournisseur")
	private Fournisseur fournisseur;
	@ManyToOne
	@JoinColumn(name = "id_livraison")
	private Livraison livraison;

	public Facture() {
		super();
		this.ligneFacture = new ArrayList<LigneFacture>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<LigneFacture> getLigneFacture() {
		return ligneFacture;
	}

	public void setLigneFacture(Collection<LigneFacture> ligneFacture) {
		this.ligneFacture = ligneFacture;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale() {
		if (this.ligneFacture != null) {
			double t = 0;
			List<LigneFacture> l = (List<LigneFacture>) this.ligneFacture;
			for(int i = 0 ; i<l.size()-1;i++)
			{
				t += l.get(i).getProduit().getPrix() * l.get(i).getQuantite();
			}
			this.totale = t;
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
