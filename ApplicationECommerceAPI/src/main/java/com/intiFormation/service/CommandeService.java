package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IcommandeDao;
import com.intiFormation.entity.Commande;

@Service
public class CommandeService implements IcommandeService {

	@Autowired
	IcommandeDao coDao;
	
	public void ajouter(Commande c) {
		coDao.save(c);
	}
	
	public void supprimer(int id) {
		coDao.deleteById(id);
	}
	
	public List<Commande> selectAll() {
		return coDao.findAll();
	}
}
