package com.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Fournisseur implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String Address;
	private String telephone;
	private String CIN;
	public Fournisseur() {
		super();
	}
	public Fournisseur(String nom, String address, String telephone, String cIN) {
		super();
		this.nom = nom;
		Address = address;
		this.telephone = telephone;
		CIN = cIN;
	}
	public Long getId() {
		return id;
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	

}
