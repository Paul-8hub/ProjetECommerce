package com.intiFormation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public class Panier {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private int idPanier;
	@JsonIgnore
	private List<LignePanier> lignePanier = new ArrayList<>();
	
	public Panier(int idPanier, List<LignePanier> lignePanier) {
		super();
		this.idPanier = idPanier;
		this.lignePanier = lignePanier;
	}
	
	public Panier(int idPanier) {
		super();
		this.idPanier = idPanier;
	}
	
	public Panier() {
		super();
	}
	
	public int getIdPanier() { return idPanier; }
	public List<LignePanier> getLignePanier() { return lignePanier; }

	public void setIdPanier(int idPanier) { this.idPanier = idPanier; }
	public void setLignePanier(List<LignePanier> lignePanier) { this.lignePanier = lignePanier; }

	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", lignePanier=" + lignePanier + "]";
	}
}