package com.intiFormation.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommande;
	private LocalDate dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> ligneCommandes;

	public Commande(int idCommande, LocalDate dateCommande, Utilisateur user, List<LigneCommande> ligneCommandes) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.user = user;
		this.ligneCommandes = ligneCommandes;
	}
	
	public Commande(LocalDate dateCommande, Utilisateur user, List<LigneCommande> ligneCommandes) {
		super();
		this.dateCommande = dateCommande;
		this.user = user;
		this.ligneCommandes = ligneCommandes;
	}
	
	public Commande(LocalDate dateCommande, Utilisateur user) {
		super();
		this.dateCommande = dateCommande;
		this.user = user;
	}
	
	public Commande() {
		super();
	}

	public int getIdCommande() { return idCommande; }
	public LocalDate getDateCommande() { return dateCommande; }
	public Utilisateur getUser() { return user; }
	public List<LigneCommande> getLigneCommandes() { return ligneCommandes; }

	public void setIdCommande(int idCommande) {	this.idCommande = idCommande; }
	public void setDateCommande(LocalDate dateCommande) { this.dateCommande = dateCommande; }
	public void setUser(Utilisateur user) { this.user = user; }
	public void setLigneCommandes(List<LigneCommande> ligneCommandes) { this.ligneCommandes = ligneCommandes; }
	

}