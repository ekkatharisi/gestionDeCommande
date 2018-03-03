package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.entity.Commande;
import com.dao.entity.Compte;
import com.dao.entity.Facture;
import com.dao.entity.Fournisseur;
import com.dao.entity.LigneCommande;
import com.dao.entity.LigneFacture;
import com.dao.entity.LigneLivraison;
import com.dao.entity.Livraison;
import com.dao.entity.Message;
import com.dao.entity.Produit;
import com.dao.repository.CommandeRepository;
import com.dao.repository.CompteRepository;
import com.dao.repository.FactureRepository;
import com.dao.repository.FournisseurRepository;
import com.dao.repository.LigneCommandeRepository;
import com.dao.repository.LigneFactureRepository;
import com.dao.repository.LigneLivraisonRepository;
import com.dao.repository.LivraisonRepository;
import com.dao.repository.MessageRepository;
import com.dao.repository.ProduitRepository;

@Service
@Transactional
public class GestionCommandeMetier implements IGestionCommandeMetier {

	@Autowired
	private ProduitRepository pr;
	@Autowired
	private FournisseurRepository fr;
	@Autowired
	private CommandeRepository cr;
	@Autowired
	private MessageRepository mr;
	@Autowired
	private CompteRepository or;
	@Autowired
	private LigneCommandeRepository lcr;
	@Autowired
	private LigneLivraisonRepository lvr;
	@Autowired
	private LivraisonRepository vr;
	@Autowired
	private FactureRepository ar;
	@Autowired
	private LigneFactureRepository lfr;
	

	@Override
	public Produit ajouterProduit(String nom, double prix) {
		Produit p = new Produit(nom, prix);
		return pr.save(p);
	}

	@Override
	public void modifierProduit(Long c, String nom, double prix) {
		Produit p = pr.findOne(c);
		p.setNom(nom);
		p.setPrix(prix);
		pr.save(p);

	}

	@Override
	public void supprimerProduit(Long c) {
		pr.delete(c);
	}

	@Override
	public void ajouterFournisseur(String n, String a, String t, String cin) {
		fr.save(new Fournisseur(n, a, t, cin));

	}

	@Override
	public void modifierFournisseur(Long id, String n, String a, String t,
			String cin) {
		Fournisseur f = fr.findOne(id);
		f.setAddress(a);
		f.setCIN(cin);
		f.setNom(n);
		f.setTelephone(t);
		fr.save(f);

	}

	@Override
	public void supprimerFoutnisseur(Long id) {

		fr.delete(id);
	}

	@Override
	public Commande ajouterCommande(Long idFrns, String date) {

		Fournisseur f = fr.findOne(idFrns);
		Commande c = new Commande();
		c.setFournisseur(f);
		c.setDateCommande(date);
		c.setLigneCommande(new ArrayList<LigneCommande>());

		return cr.save(c);

	}

	@Override
	public void modifierCommande(Long id, Long idFrns, String date,
			List<LigneCommande> LigneCommande) {
		Fournisseur f = fr.findOne(idFrns);
		Commande c = cr.findOne(id);
		c.setFournisseur(f);
		c.setLigneCommande(LigneCommande);
		c.setDateCommande(date);
		cr.save(c);
	}

	@Override
	public void supprimerCommande(Long id) {

		cr.delete(id);

	}

	@Override
	public void remplirCommande(Long idCommande, Long p, int quantite) {

		Commande c = cr.findOne(idCommande);
		Produit pp = pr.findOne(p);
		LigneCommande l = new LigneCommande(c, pp, quantite);
		lcr.save(l);
		c.getLigneCommande().add(l);
		cr.save(c);
	}

	@Override
	public Fournisseur getFournisseur(Long id) {

		return fr.findOne(id);
	}

	@Override
	public List<Fournisseur> getListFournisseur() {

		return fr.findAll();
	}

	@Override
	public List<Commande> getListCommande() {
		return cr.findAll();
	}

	@Override
	public Compte getCompte(Long id) {

		return or.findOne(id);
	}

	@Override
	public List<Compte> getListCompte() {

		return or.findAll();
	}

	@Override
	public Compte ajouterCompte(String nom, String email, String pw, String role) {
		Compte c = new Compte(nom, email, pw, role);
		c.setBoiteBonDeCommande(new ArrayList<Commande>());
		c.setBoiteMessage(new ArrayList<Message>());
		or.save(c);

		return c;
	}

	@Override
	public void modifierCompte(Long id, String nom, String email, String pw,
			String role) {
		Compte c = or.findOne(id);
		c.setNom(nom);
		c.setEmail(email);
		c.setPassword(pw);
		c.setRole(role);
		or.save(c);

	}

	@Override
	public void supprimerCompte(Long id) {
		or.delete(id);

	}

	@Override
	public void remplirBoitBonDeCommande(Long id, Long codeCommande) {
		Compte c = or.findOne(id);
		Commande cc = cr.findOne(codeCommande);
		c.getBoiteBonDeCommande().add(cc);
		or.save(c);

	}

	@Override
	public void remplirBoitMessage(Long id, Long idm) {
		Compte c = or.findOne(id);
		Message m = mr.findOne(idm);
		c.getBoiteMessage().add(m);
		or.save(c);

	}

	@Override
	public Message getMessage(Long id) {

		return mr.findOne(id);
	}

	@Override
	public Message ajouterMessage(String sujet, String msg, String em) {

		return mr.save(new Message(sujet, msg, em));
	}

	@Override
	public void setMessageCompte(Long id, Compte c) {
		Message m = mr.findOne(id);
		m.setCompte(c);
		mr.save(m);
	}

	@Override
	public void setCommandeCompte(Long id, Compte c) {
		Commande m = cr.findOne(id);
		m.setCompte(c);
		cr.save(m);
	}

	@Override
	public Commande getCommande(Long id) {

		return cr.findOne(id);
	}

	@Override
	public Livraison ajouterLivraison(Long idFrns, String date , Commande cmd) {

		Fournisseur f = fr.findOne(idFrns);
		Livraison v = new Livraison();
		v.setFournisseur(f);
		v.setDateLivraison(date);
		v.setCommande(cmd);
		v.setLigneLivraison(new ArrayList<LigneLivraison>());

		return vr.save(v);
	}

	@Override
	public void remplirLivraison(Long idLivraison, Long codeProduit,
			int quantite) {
		Livraison v = vr.findOne(idLivraison);
		Produit pp = pr.findOne(codeProduit);
		LigneLivraison l = new LigneLivraison(v, pp, quantite);
		lvr.save(l);
		v.getLigneLivraison().add(l);
		vr.save(v);

	}

	@Override
	public void modifierLivraison(Long id, Long idFrns, String date, Long cmd,
			List<LigneLivraison> LigneLivraison)
	{
		Fournisseur f = fr.findOne(idFrns);
		Commande c = cr.findOne(cmd);
		Livraison v = vr.findOne(id);
		v.setFournisseur(f);
		v.setCommande(c);
		v.setDateLivraison(date);
		v.setLigneLivraison(LigneLivraison);
		vr.save(v);

	}

	@Override
	public void supprimerLivraison(Long id) {

		vr.delete(id);

	}

	@Override
	public List<Livraison> getListLivraison() {
		return vr.findAll();
	}

	@Override
	public void setLivraisonCompte(Long id, Compte c) {

		Livraison v = vr.findOne(id);
		v.setCompte(c);
		vr.save(v);

	}

	@Override
	public Livraison getLivraison(Long id) {
		return vr.findOne(id);
	}

	@Override
	public void setLivraisonCommande(Long id, Commande cmd) {

		Livraison v = vr.findOne(id);
		v.setCommande(cmd);
		vr.save(v);

	}

	@Override
	public void setStatusLivraison(Long id, String status) {
		Livraison v = vr.findOne(id);
		v.setStatus(status);
		vr.save(v);
	}

	@Override
	public Facture ajouterFacture(Long idFrns, Long idLiv) {
		
		Facture fac = new Facture();
		Fournisseur f = fr.findOne(idFrns);
		Livraison v = vr.findOne(idLiv);
		fac.setFournisseur(f);
		fac.setLivraison(v);
		fac.setLigneFacture(new ArrayList<>());
		
		return ar.save(fac);
	}

	@Override
	public void remplirFacture(Long idFacture, Long codeProduit, int quantite) {
		Facture f = ar.findOne(idFacture);
		Produit pp = pr.findOne(codeProduit);
		LigneFacture l = new LigneFacture();
		l.setFacture(f);
		l.setProduit(pp);
		l.setQuantite(quantite);
		lfr.save(l);
		f.getLigneFacture().add(l);
		f.setTotale();
		ar.save(f);
		
	}

	

	@Override
	public void supprimerFacture(Long id) {
		ar.delete(id);
		
	}

	@Override
	public List<Facture> getListFacture() {
		return ar.findAll();
	}

	@Override
	public Facture getFacture(Long id) {
		return ar.findOne(id);
	}

	@Override
	public Facture getFactureByLivraison(Long id) {

		return ar.findByLivraison(id);
	}

	@Override
	public void setFactureLivraison(Long id, Livraison v) {
		Facture f = ar.findOne(id);
		f.setLivraison(v);
		ar.save(f);
	}

	@Override
	public void setStatusFacture(Long idFac ,boolean s) {
		Facture f = ar.findOne(idFac);
		f.setStatus(s);
		ar.save(f);
	}

}
