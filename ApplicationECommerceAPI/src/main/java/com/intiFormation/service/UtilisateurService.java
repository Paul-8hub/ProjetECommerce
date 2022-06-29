package com.intiFormation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IutilisateurDao;
import com.intiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IutilisateurService {

	@Autowired
	IutilisateurDao uDao;
	
	public void ajouter(Utilisateur u) {
		uDao.save(u);
	}
	
	public Utilisateur chercherParLogin(String login) {
		return uDao.findByLogin(login);
	}
}