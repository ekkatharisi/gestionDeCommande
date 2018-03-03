package com.metier;

import java.util.List;

import com.dao.entity.Commande;
import com.dao.entity.Compte;
import com.dao.entity.Facture;
import com.dao.entity.Fournisseur;
import com.dao.entity.LigneCommande;
import com.dao.entity.LigneLivraison;
import com.dao.entity.Livraison;
import com.dao.entity.Message;
import com.dao.entity.Produit;


public interface IGestionCommandeMetier {

	public Produit ajouterProduit(String nom , double prix);
	public void modifierProduit(Long c , String nom , double prix);
	public void supprimerProduit(Long c);
	
	public void ajouterFournisseur(String n , String a , String t , String cin);
	public void modifierFournisseur(Long id ,String n , String a , String t , String cin);
	public void supprimerFoutnisseur(Long id);
	public Fournisseur getFournisseur(Long id);
	public List<Fournisseur> getListFournisseur();
	
	public Commande ajouterCommande(Long idFrns,String date);
	public void remplirCommande(Long idCommande , Long codeProduit , int quantite);
	public void modifierCommande(Long id,Long idFrns,String date,List<LigneCommande> LigneCommande);
	public void supprimerCommande(Long id);
	public List<Commande> getListCommande();
	public void setCommandeCompte(Long id , Compte c);
	public Commande getCommande(Long id); 
	
	public Compte getCompte(Long id);
	public List<Compte> getListCompte();
	public Compte ajouterCompte(String nom , String email , String pw , String  role);
	public void modifierCompte(Long id , String nom , String email , String pw , String role); 
	public void supprimerCompte(Long id);
	public void remplirBoitBonDeCommande(Long idComtpe , Long CodeCommande );
	public void remplirBoitMessage(Long id , Long idMsg);
	
	public Message getMessage(Long id);
	public Message ajouterMessage(String sujet, String msg , String em );
	public void setMessageCompte(Long id , Compte c);
	
	public Livraison ajouterLivraison(Long idFrns,String date , Commande cmd);
	public void remplirLivraison(Long idLivraison , Long codeProduit , int quantite);
	public void modifierLivraison(Long id,Long idFrns,String date,Long cmd,List<LigneLivraison> LigneLivraison);
	public void supprimerLivraison(Long id);
	public List<Livraison> getListLivraison();
	public void setLivraisonCompte(Long id , Compte c);
	public void setLivraisonCommande(Long id , Commande cmd);
	public Livraison getLivraison(Long id);
	public void setStatusLivraison(Long id , String status);
	
	public Facture  ajouterFacture(Long idFrns,Long idLiv);
	public void remplirFacture(Long idFacture , Long codeProduit , int quantite);
	public void supprimerFacture(Long id);
	public List<Facture> getListFacture();
	public Facture getFacture(Long id);
	public Facture getFactureByLivraison(Long id);
	public void setFactureLivraison(Long id , Livraison v);
	public void setStatusFacture(Long idFac , boolean s);
	
}
