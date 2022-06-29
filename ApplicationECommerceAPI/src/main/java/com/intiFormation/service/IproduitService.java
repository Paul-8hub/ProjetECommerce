package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Produit;

public interface IproduitService {

	public void ajouter_modifier(Produit p);
	public void supprimer(int id) ;
	public List<Produit> selectAll();
	public Produit selectById(int idProduit);
	public List<Produit> selectByLibProduit(String libProduit);
	public List<Produit> selectByIdCat(int idCat);
}
