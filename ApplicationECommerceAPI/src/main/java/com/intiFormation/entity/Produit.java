package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduit;
	@Column(name="nomProduit")
	private String libProduit;
	@Column(name="imgProduit")
	private String img;
	@Column(name="qteProdDispo")
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name="idCat")
	private Categorie categorie;
	@Transient
	private List<LignePanier> lignePanier;
	/*@OneToMany(mappedBy="produit")
	private List<LigneCommande> ligneCommandes;*/
	
	public Produit(int idProduit, String libProduit, String img, int quantite, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.libProduit = libProduit;
		this.img = img;
		this.quantite = quantite;
		this.categorie = categorie;
	}
	
	public Produit(String libProduit, String img, int quantite, Categorie categorie) {
		this.libProduit = libProduit;
		this.img = img;
		this.quantite = quantite;
		this.categorie = categorie;
	}
	
	public Produit() {
		super();
	}

	public int getIdProduit() { return idProduit; }
	public String getLibProduit() { return libProduit; }
	public String getImg() { return img; }
	public int getQuantite() { return quantite; }
	public Categorie getCategorie() { return categorie; }
	/*public List<LignePanier> getLignePanier() { return lignePanier; }
	public List<LigneCommande> getLigneCommandes() { return ligneCommandes; }*/
	
	public void setIdProduit(int idProduit) { this.idProduit = idProduit; }
	public void setLibProduit(String libProduit) { this.libProduit = libProduit; }
	public void setImg(String img) { this.img = img; }
	public void setQuantite(int quantite) { this.quantite = quantite; }
	public void setCategorie(Categorie categorie) {	this.categorie = categorie; }
	/*public void setLignePanier(List<LignePanier> lignePanier) { this.lignePanier = lignePanier; }
	public void setLigneCommandes(List<LigneCommande> ligneCommandes) { this.ligneCommandes = ligneCommandes; }*/

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", libProduit=" + libProduit + ", img=" + img + ", quantite="
				+ quantite + ", categorie=" + categorie + "]";
	}
}