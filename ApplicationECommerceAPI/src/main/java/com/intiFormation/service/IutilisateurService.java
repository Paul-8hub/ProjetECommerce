package com.intiFormation.service;

import com.intiFormation.entity.Utilisateur;

public interface IutilisateurService {

	public void ajouter(Utilisateur u);
	public Utilisateur chercherParLogin(String login);
}