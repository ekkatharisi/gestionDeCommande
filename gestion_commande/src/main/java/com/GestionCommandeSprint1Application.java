package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dao.entity.Commande;
import com.metier.IGestionCommandeMetier;

@SpringBootApplication
public class GestionCommandeSprint1Application implements CommandLineRunner {

	@Autowired
	private IGestionCommandeMetier gc;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GestionCommandeSprint1Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		gc.ajouterProduit("produit1",20999);
		gc.ajouterProduit("produit2",304004);
		gc.ajouterProduit("produit3",40000);
		gc.ajouterProduit("produit4",1050000);
		gc.ajouterProduit("produit5",500345);
		gc.ajouterProduit("produit6",559995);
		gc.ajouterProduit("produit7",791944);
		gc.ajouterProduit("produit8",810434);
		
		
		gc.ajouterFournisseur("chaabaoui aymene", "adress", "0645235465", "DF3DS34");
		gc.ajouterFournisseur("alaoui mohamed", "address 2", "0645234355", "CF4RD4R");
		gc.ajouterFournisseur("ilyass adnani", "address 3", "0343545465", "EDE4D4R");
		
		Commande c = gc.ajouterCommande(1L,"11/1/2018");
		gc.remplirCommande(1L, 1L, 10);
		gc.remplirCommande(1L, 2L, 10);
		Commande c2 = gc.ajouterCommande(1L,"23/5/2017");
		gc.remplirCommande(2L, 1L, 112);
		gc.remplirCommande(2L, 3L, 129);
		gc.remplirCommande(2L, 4L, 234);
		Commande c3 = gc.ajouterCommande(2L,"11/1/2018");
		gc.remplirCommande(3L, 3L, 456);
		gc.remplirCommande(3L, 4L, 231);
		gc.remplirCommande(3L, 7L, 35);
		gc.remplirCommande(3L, 6L, 236);
		gc.remplirCommande(3L, 8L, 123);
		gc.remplirCommande(3L, 5L, 688);
		Commande c4 = gc.ajouterCommande(3L,"11/1/2018");
		gc.remplirCommande(4L, 7L, 100);
		gc.remplirCommande(4L, 3L, 1012);
		
		gc.ajouterCompte("chay", "stock@admin.com", "123", "s");
		gc.ajouterCompte("chay", "financier@admin.com", "123", "f");
		gc.ajouterCompte("chay", "achat@admin.com", "123", "a");
		
		gc.ajouterLivraison(1L, "30/3/2018",c);
		gc.remplirLivraison(1L, 1L, 10);
		gc.remplirLivraison(1L, 2L, 10);
		gc.ajouterLivraison(2L, "12/4/2018",c3);
		gc.remplirLivraison(2L, 3L, 456);
		gc.remplirLivraison(2L, 4L, 231);
		gc.remplirLivraison(2L, 7L, 35);
		gc.remplirLivraison(2L, 6L, 236);
		gc.remplirLivraison(2L, 8L, 123);
		gc.remplirLivraison(2L, 5L, 688);
		gc.ajouterLivraison(3L, "23/7/2018",c3);
		gc.remplirLivraison(3L, 1L, 321);
		gc.remplirLivraison(3L, 8L, 123);
		
		gc.ajouterFacture(1L,1L);
		gc.remplirFacture(1L, 1L, 10);
		gc.remplirFacture(1L, 2L, 10);
		gc.ajouterFacture(2L,2L);
		gc.remplirFacture(2L, 8L, 123);
		gc.remplirFacture(2L, 7L, 35);
		gc.remplirFacture(2L, 6L, 236);
		gc.remplirFacture(2L, 3L, 456);
		gc.remplirFacture(2L, 4L, 231);
		gc.remplirFacture(2L, 5L, 688);
		gc.ajouterFacture(3L,3L);
		gc.remplirFacture(3L, 8L, 123);
		gc.remplirFacture(3L, 2L, 456);
		
		
	}
}
