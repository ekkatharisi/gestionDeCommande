package com.dao.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Compte implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String email;
	private String password;
	private String role;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="compte")
	private Collection<Commande> boiteBonDeCommande;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="compte")
	private Collection<Message> boiteMessage;
	public Compte() {
		super();
	}
	public Compte(String nom, String email, String password, String role,
			Collection<Commande> boiteBonDeCommande,
			Collection<Message> boiteMessage) {
		super();
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.boiteBonDeCommande = boiteBonDeCommande;
		this.boiteMessage = boiteMessage;
	}
	public Long getId() {
		return id;
	}
	
	public Compte( String nom, String email, String password,
			String role) {
		super();
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Collection<Commande> getBoiteBonDeCommande() {
		return boiteBonDeCommande;
	}
	public void setBoiteBonDeCommande(Collection<Commande> boiteBonDeCommande) {
		this.boiteBonDeCommande = boiteBonDeCommande;
	}
	public Collection<Message> getBoiteMessage() {
		return boiteMessage;
	}
	public void setBoiteMessage(Collection<Message> boiteMessage) {
		this.boiteMessage = boiteMessage;
	}
	
	

}
