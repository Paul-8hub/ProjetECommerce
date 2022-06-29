package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Commande;

public interface IcommandeService {
	
	public void ajouter(Commande c);
	public void supprimer(int id);
	public List<Commande> selectAll();
}
