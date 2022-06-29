package com.intiFormation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLigneCommande;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	@Column(name="qte")
	private int quantite;

	public LigneCommande(Commande commande, Produit produit, int quantite) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
	}
	
	public LigneCommande() {
		super();
	}

	public int getIdLigneCommande() { return idLigneCommande; }
	public Commande getCommande() { return commande; }
	public Produit getProduit() { return produit; }
	public int getQuantite() { return quantite; }

	public void setIdLigneCommande(int idLigneCommande) { this.idLigneCommande = idLigneCommande; }
	public void setCommande(Commande commande) { this.commande = commande; }
	public void setProduit(Produit produit) { this.produit = produit; }
	public void setQuantite(int quantite) {	this.quantite = quantite; }
}
