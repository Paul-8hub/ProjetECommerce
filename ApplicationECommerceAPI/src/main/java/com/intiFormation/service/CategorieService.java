package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IcategorieDao;
import com.intiFormation.entity.Categorie;

@Service
public class CategorieService implements IcategorieService {
	
	@Autowired
	IcategorieDao cDao;

	public IcategorieDao getcDao() { return cDao; }
	public void setcDao(IcategorieDao cDao) { this.cDao = cDao; }

	public void ajouter_modifier(Categorie c) {
		cDao.save(c);
	}
	
	public void supprimer(int id) {
		cDao.deleteById(id);
	}
	
	public Categorie selectById(int idCat) {
		return cDao.findById(idCat);
	}
	
	public Categorie selectByNomCat(String nomCategorie) {
		return cDao.findByNomCategorie(nomCategorie);
	}
	
	public List<Categorie> selectAll() {
		return cDao.findAll();
	}
}