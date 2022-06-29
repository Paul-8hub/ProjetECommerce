package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Categorie;

public interface IcategorieService {
	
	public void ajouter_modifier(Categorie c);
	public void supprimer(int id);
	public Categorie selectById(int idCat);
	public Categorie selectByNomCat(String nomCategorie);
	public List<Categorie> selectAll();
}
