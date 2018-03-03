package com.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import com.metier.IGestionCommandeMetier;

@Controller
public class Ctrl01 {

	@Autowired
	private IGestionCommandeMetier g;

	private Compte compteConnecte = null;

	@RequestMapping("/")
	public String home(Model m, boolean msgErr, boolean msgErrRef,
			boolean msgErrCom, boolean msgErrTot, boolean msgVal) {
		
		m.addAttribute("compteConnecte", compteConnecte);
		m.addAttribute("msgErr", msgErr);
		m.addAttribute("msgErrRef", msgErrRef);
		m.addAttribute("msgErrCom", msgErrCom);
		m.addAttribute("msgErrTot", msgErrTot);
		m.addAttribute("msgVal", msgVal);
		m.addAttribute("factures", g.getListFacture());

		return "home";
	}

	@RequestMapping("/ajFrns.html")
	public String ajouterFounisseurView(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		return "ajouterFournisseur";
	}

	@RequestMapping("/ajFrns")
	public String ajouterFounisseurTraitments(Model m, String nom, String ad,
			String tel, String cin) {
		m.addAttribute("compteConnecte", compteConnecte);

		g.ajouterFournisseur(nom, ad, tel, cin);

		return "redirect:/";
	}

	@RequestMapping("/modFrns1.html")
	public String modifierFournisseur(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		System.out.println(g.getListFournisseur().size());
		m.addAttribute("fournisseurs", g.getListFournisseur());

		return "modifierFournisseur1";
	}

	@RequestMapping("/modFrns1")
	public String modifierFournisseurTraitements(Model m, Long frns) {
		m.addAttribute("compteConnecte", compteConnecte);

		Fournisseur f = g.getFournisseur(frns);
		m.addAttribute("frns", f);

		return "modifierFournisseur2";
	}

	@RequestMapping("/modFrns2")
	public String modifierFournisseurTraitements2(Model m, Long id, String nom,
			String ad, String tel, String cin) {

		g.modifierFournisseur(id, nom, ad, tel, cin);

		return "redirect:/";
	}

	@RequestMapping("/supFrns.html")
	public String supprimerFournisseur(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		System.out.println(g.getListFournisseur().size());
		m.addAttribute("fournisseurs", g.getListFournisseur());
		m.addAttribute("msg", false);

		return "supprimerFournisseur";
	}

	@RequestMapping("/supFrns")
	public String supprimerFournisseurTraitement(Model m, Long frns) {
		try {

			g.supprimerFoutnisseur(frns);
			return "redirect:/";

		} catch (Exception e) {
			m.addAttribute("compteConnecte", compteConnecte);

			m.addAttribute("msg", true);
			return "supprimerFournisseur";
		}

	}

	@RequestMapping("/consulterFrns.html")
	public String consulterFournisseur(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		m.addAttribute("fournisseurs", g.getListFournisseur());
		return "consulterFournisseurs";
	}

	@RequestMapping("/ajCmd.html")
	public String ajouterCommande(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		m.addAttribute("fournisseurs", g.getListFournisseur());

		return "ajouterCommande";
	}

	@RequestMapping("/ajCmd")
	public String ajouterCommandeTraitements(Model m, Long frns, String n1,
			double p1, int q1, String n2, double p2, int q2, String n3,
			double p3, int q3, String n4, double p4, int q4, String n5,
			double p5, int q5, String n6, double p6, int q6) {
		// System.out.println("n1 = "+n1+" , p1 = "+p1+" , q1 = "+q1);
		Commande c;
		if (frns != 0L) {
			Date now = new Date();
			SimpleDateFormat dateFormatter = new SimpleDateFormat(
					"EEEE, MMMM d, yyyy");
			c = g.ajouterCommande(frns, dateFormatter.format(now));
			if (n1 != null && p1 != 0 && q1 != 0) {
				Produit p = g.ajouterProduit(n1, p1);
				g.remplirCommande(c.getId(), p.getCode(), q1);
			}
			if (n2 != null && p2 != 0 && q2 != 0) {
				Produit p = g.ajouterProduit(n2, p2);
				g.remplirCommande(c.getId(), p.getCode(), q2);
			}
			if (n3 != null && p3 != 0 && q3 != 0) {
				Produit p = g.ajouterProduit(n3, p3);
				g.remplirCommande(c.getId(), p.getCode(), q3);
			}
			if (n4 != null && p4 != 0 && q4 != 0) {
				Produit p = g.ajouterProduit(n4, p4);
				g.remplirCommande(c.getId(), p.getCode(), q4);
			}
			if (n5 != null && p5 != 0 && q5 != 0) {
				Produit p = g.ajouterProduit(n5, p5);
				g.remplirCommande(c.getId(), p.getCode(), q5);
			}
			if (n6 != null && p6 != 0 && q6 != 0) {
				Produit p = g.ajouterProduit(n6, p6);
				g.remplirCommande(c.getId(), p.getCode(), q6);
			}
		}
		return "redirect:/";
	}

	@RequestMapping("/consulterCmd.html")
	public String consulterCommande(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		m.addAttribute("commandes", g.getListCommande());

		return "consulterCommande";
	}

	@RequestMapping("/auth")
	public String authetification(RedirectAttributes m, String email, String pw) {
		List<Compte> c = g.getListCompte();
		Compte ccc = null;
		for (Compte cc : c) {
			if (cc.getEmail().equalsIgnoreCase(email)
					&& cc.getPassword().equalsIgnoreCase(pw)) {
				ccc = cc;
			}
		}
		compteConnecte = ccc;
		if (compteConnecte == null) {
			m.addAttribute("msgErr", true);
		}

		return "redirect:/";
	}

	@RequestMapping("/register.html")
	public String registerView(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		return "ajouterCompte";
	}

	@RequestMapping("/register")
	public String register(Model m, String nom, String email, String pw,
			String role) {
		boolean d = false;

		for (Compte c : g.getListCompte()) {
			if (c.getEmail().equalsIgnoreCase(email)) {
				d = true;
			}
		}
		if (d) {
			m.addAttribute("compteConnecte", compteConnecte);
			m.addAttribute("msgErr", true);
			return "ajouterCompte";
		} else {
			m.addAttribute("msgErr", false);
			g.ajouterCompte(nom, email, pw, role);
			return "redirect:/";
		}

	}

	@RequestMapping("/deconnexion")
	public String deconnexion() {
		compteConnecte = null;
		return "redirect:/";
	}

	@RequestMapping("/envoyerMsg.html")
	public String envoyerMsgView(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		return "envoyerMessage";
	}

	@RequestMapping("/envoyerMsg")
	public String envoyerMsg(String dest, String sujet, String msg) {
		List<Compte> cs = g.getListCompte();
		for (Compte c : cs) {
			if (c.getRole().equalsIgnoreCase(dest)) {
				Message m;
				if (compteConnecte.getRole().equalsIgnoreCase("a")) {
					m = g.ajouterMessage(sujet, msg, "service d'achat");
				} else {
					if (compteConnecte.getRole().equalsIgnoreCase("s")) {
						m = g.ajouterMessage(sujet, msg, "service de stock");
					} else {
						m = g.ajouterMessage(sujet, msg, "service financier");
					}
				}
				g.setMessageCompte(m.getId(), c);
				g.remplirBoitMessage(c.getId(), m.getId());
			}
		}

		return "redirect:/";
	}

	@RequestMapping("/envoyerCmd.html")
	public String envoyerCmdView(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);
		m.addAttribute("commandes", g.getListCommande());

		return "envoyerCommande";
	}

	@RequestMapping("/envoyerCmd")
	public String envoyerCmd(String dest, Long cmd) {
		List<Compte> cs = g.getListCompte();
		for (Compte c : cs) {
			if (c.getRole().equalsIgnoreCase(dest)) {
				Commande cc = g.getCommande(cmd);
				g.setCommandeCompte(cmd, c);
				g.remplirBoitBonDeCommande(c.getId(), cc.getId());
			}
		}
		return "redirect:/";
	}

	@RequestMapping("/affMsg.html")
	public String afficherMessage(Model m, Long id) {
		m.addAttribute("compteConnecte", compteConnecte);
		m.addAttribute("msg", g.getMessage(id));
		return "afficherMessage";
	}

	@RequestMapping("/affCmd.html")
	public String afficherCommande(Model m, Long id) {
		m.addAttribute("compteConnecte", compteConnecte);
		m.addAttribute("cmd", g.getCommande(id));

		return "afficherCommande";
	}

	@RequestMapping("/ajLiv.html")
	public String ajouterLivraisonView(Model m) {
		m.addAttribute("compteConnecte", compteConnecte);

		m.addAttribute("commandes", g.getListCommande());

		m.addAttribute("fournisseurs", g.getListFournisseur());

		return "ajouterLivraison";
	}

	@RequestMapping("/ajLiv")
	public String ajouterLivraison(Model m, Long frns, Long cmd, String n1,
			double p1, int q1, String n2, double p2, int q2, String n3,
			double p3, int q3, String n4, double p4, int q4, String n5,
			double p5, int q5, String n6, double p6, int q6) {
		// System.out.println("n1 = "+n1+" , p1 = "+p1+" , q1 = "+q1);
		Livraison v;
		if (frns != 0L && cmd != 0L) {
			Date now = new Date();
			SimpleDateFormat dateFormatter = new SimpleDateFormat(
					"EEEE, MMMM d, yyyy");
			v = g.ajouterLivraison(frns, dateFormatter.format(now),
					g.getCommande(cmd));
			g.setLivraisonCommande(v.getId(), g.getCommande(cmd));
			if (n1 != null && p1 != 0 && q1 != 0) {
				Produit p = g.ajouterProduit(n1, p1);
				g.remplirLivraison(v.getId(), p.getCode(), q1);
			}
			if (n2 != null && p2 != 0 && q2 != 0) {
				Produit p = g.ajouterProduit(n2, p2);
				g.remplirLivraison(v.getId(), p.getCode(), q2);
			}
			if (n3 != null && p3 != 0 && q3 != 0) {
				Produit p = g.ajouterProduit(n3, p3);
				g.remplirLivraison(v.getId(), p.getCode(), q3);
			}
			if (n4 != null && p4 != 0 && q4 != 0) {
				Produit p = g.ajouterProduit(n4, p4);
				g.remplirLivraison(v.getId(), p.getCode(), q4);
			}
			if (n5 != null && p5 != 0 && q5 != 0) {
				Produit p = g.ajouterProduit(n5, p5);
				g.remplirLivraison(v.getId(), p.getCode(), q5);
			}
			if (n6 != null && p6 != 0 && q6 != 0) {
				Produit p = g.ajouterProduit(n6, p6);
				g.remplirLivraison(v.getId(), p.getCode(), q6);
			}
		}
		return "redirect:/";
	}

	@RequestMapping("/consulterLiv.html")
	public String consulterLivraison(Model m) {

		m.addAttribute("compteConnecte", compteConnecte);
		m.addAttribute("livraisons", g.getListLivraison());

		return "consulterLivraison";
	}

	@RequestMapping("/verif")
	public String verificationLivraison(Model m, Long idLiv, Long idCmd) {
		m.addAttribute("compteConnecte", compteConnecte);
		m.addAttribute("livraisons", g.getListLivraison());
		Livraison v = g.getLivraison(idLiv);
		Commande c = g.getCommande(idCmd);
		Facture f = g.getFactureByLivraison(v.getId());

		Collection<LigneLivraison> liv = v.getLigneLivraison();
		Collection<LigneCommande> cmd = c.getLigneCommande();
		boolean egaux = false;
		for (LigneLivraison l : liv) {
			egaux = false;

			for (LigneCommande cc : cmd) {
				if (l.getProduit().getNom()
						.equalsIgnoreCase(cc.getProduit().getNom())
						&& cc.getQuantite() == l.getQuantite()
						&& cc.getProduit().getPrix() == l.getProduit()
								.getPrix()) {
					egaux = true;
				}
			}
			if (!egaux) {
				break;
			}
		}

		if (egaux) {
			m.addAttribute("msgErr", false);
			m.addAttribute("msgVal", true);
			g.setStatusLivraison(v.getId(), "a");

		} else {
			m.addAttribute("msgErr", true);
			m.addAttribute("msgVal", false);
			g.setStatusLivraison(v.getId(), "r");
		}
		g.setFactureLivraison(f.getId(), v);

		return "consulterLivraison";
	}

	@RequestMapping("/reglerFacture")
	public String afficherFactureView(Model m , Long idFac) {

		Facture f = g.getFacture(idFac);
		Livraison l = f.getLivraison();
		Collection<LigneLivraison> liv = l.getLigneLivraison();
		Collection<LigneFacture> fac = f.getLigneFacture();
		boolean msgErrRefused = false;
		boolean msgErrComfm = false;
		boolean msgErrTotale = false;
		boolean msgVal = false;
		boolean egaux = false;
		double totale = 0;
		System.out.println(l.getStatus());
		if (l.getStatus() != null && l.getStatus().equalsIgnoreCase("a")) {

			for (LigneLivraison ll : liv) {
				egaux = false;

				for (LigneFacture ff : fac) {
					if (ll.getProduit().getNom()
							.equalsIgnoreCase(ff.getProduit().getNom())
							&& ff.getQuantite() == ll.getQuantite()
							&& ff.getProduit().getPrix() == ll.getProduit()
									.getPrix()) {
						egaux = true;
						totale += ll.getProduit().getPrix() * ll.getQuantite();
					}
				}
				if (!egaux) {
					break;
				}
			}

			if (egaux) {
				if (totale != f.getTotale()) {
					msgErrTotale = true;
				} else {
					msgVal = true;
					g.setStatusFacture(f.getId(), true);
				}

			} else {
				msgErrComfm = true;
			}
		} else {
			msgErrRefused = true;
		}

		m.addAttribute("msgErrRef", msgErrRefused);
		m.addAttribute("msgErrCom", msgErrComfm);
		m.addAttribute("msgErrTot", msgErrTotale);
		m.addAttribute("l", l);
		m.addAttribute("f",f);
		m.addAttribute("facture",f);
		m.addAttribute("totale", totale);
		m.addAttribute("msgVal", msgVal);
		m.addAttribute("compteConnecte", compteConnecte);
		if(msgVal)
		{
			return "afficherFacture";
		}
		else
		{
			return "errReglerFacture";
		}
	}
	
	@RequestMapping("/affFacture")
	public String afficherFacture(Model m ,Long id)
	{
		Facture f = g.getFacture(id);
		m.addAttribute("facture", f);
		
		return "afficherFacture";
	}

}
