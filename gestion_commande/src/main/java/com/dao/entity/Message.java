package com.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String sujet;
	private String message;
	private String emeteur;
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;
	public Message() {
		super();
	}
	
	public Message(String sujet, String message, String emeteur) {
		super();
		this.sujet = sujet;
		this.message = message;
		this.emeteur = emeteur;
	}

	public Message(String sujet, String message, String emeteur, Compte compte) {
		super();
		this.sujet = sujet;
		this.message = message;
		this.emeteur = emeteur;
		this.compte = compte;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmeteur() {
		return emeteur;
	}
	public void setEmeteur(String emeteur) {
		this.emeteur = emeteur;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	
	
}