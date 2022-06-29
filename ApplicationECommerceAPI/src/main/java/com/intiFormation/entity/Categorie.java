package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCat")
	private int idCategorie;
	@Column(name="nomCat")
	private String nomCategorie;
	@Column(name="descCat")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy= "categorie", cascade = {CascadeType.REMOVE})
	private List<Produit> produits;
	
	public Categorie(int idCategorie, String nomCategorie, String description, List<Produit> produits) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.produits = produits;
	}
	
	public Categorie(int idCategorie, String nomCategorie, String description) {
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	
	public Categorie(String nomCategorie, String description) {
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	
	public Categorie() {
		super();
	}

	public int getIdCategorie() { return idCategorie; }
	public String getNomCategorie() { return nomCategorie; }
	public String getDescription() { return description; }
	public List<Produit> getProduits() { return produits; }

	public void setIdCategorie(int idCategorie) { this.idCategorie = idCategorie; }
	public void setNomCategorie(String nomCategorie) { this.nomCategorie = nomCategorie; }
	public void setDescription(String description) { this.description = description; }
	public void setProduits(List<Produit> produits) { this.produits = produits; }

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", description="
				+ description + "]";
	}
}
