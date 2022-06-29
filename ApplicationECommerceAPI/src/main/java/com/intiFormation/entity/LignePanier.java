package com.intiFormation.entity;

//Ce n'est pas une entité dans la base de données
public class LignePanier {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private int idLignePanier;
	private Panier panier;
	private Produit produitP;
	private int quantite;
	
	public LignePanier(int idLignePanier, Panier panier, Produit produit, int quantite) {
		super();
		this.idLignePanier = idLignePanier;
		this.panier = panier;
		this.produitP = produit;
		this.quantite = quantite;
	}
	
	public LignePanier(Panier panier, Produit produit, int quantite) {
		super();
		this.panier = panier;
		this.produitP = produit;
		this.quantite = quantite;
	}
	
	public LignePanier() {
		super();
	}

	public int getIdLignePanier() { return idLignePanier; }
	public Produit getProduit() { return produitP; }
	public Panier getPanier() { return panier; }	
	public int getQuantite() { return quantite; }

	public void setIdLignePanier(int idLignePanier) { this.idLignePanier = idLignePanier; }
	public void setPanier(Panier panier) { this.panier = panier; }
	public void setProduit(Produit produit) { this.produitP = produit; }
	public void setQuantite(int quantite) { this.quantite = quantite; }

	@Override
	public String toString() {
		return "LignePanier [idLignePanier=" + idLignePanier + ", produitP=" + produitP
				+ ", quantite=" + quantite + "]";
	}
}