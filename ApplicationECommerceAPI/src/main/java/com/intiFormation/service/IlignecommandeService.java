package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.LigneCommande;

public interface IlignecommandeService {
	public void ajouter(LigneCommande lc);
	public void supprimer(int id);
	public List<LigneCommande> selectAll();
}
