package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IlignecommandeDao;
import com.intiFormation.entity.LigneCommande;

@Service
public class LigneCommandeService implements IlignecommandeService {

	@Autowired
	IlignecommandeDao lcDao;
	
	public void ajouter(LigneCommande lc) {
		lcDao.save(lc);
	}
	
	public void supprimer(int id) {
		lcDao.deleteById(id);
	}
	
	public List<LigneCommande> selectAll() {
		return lcDao.findAll();
	}
}
