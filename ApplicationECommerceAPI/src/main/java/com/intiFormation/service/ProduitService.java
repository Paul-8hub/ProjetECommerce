package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IproduitDao;
import com.intiFormation.entity.Produit;

@Service
public class ProduitService implements IproduitService {

	@Autowired
	IproduitDao pDao;
	
	public IproduitDao getpDao() { return pDao; }
	public void setpDao(IproduitDao pDao) { this.pDao = pDao; }
	
	public void ajouter_modifier(Produit p) {
		pDao.save(p);
	}
	
	public void supprimer(int id) {
		pDao.deleteById(id);
	}

	public Produit selectById(int idProduit) {
		return pDao.findById(idProduit);
	}
	
	public List<Produit> selectByLibProduit(String libProduit) {
		return pDao.findByLibProduit(libProduit);
	}
	
	public List<Produit> selectByIdCat(int idCat) {
		return pDao.findByCategorie_idCategorie(idCat);
	}
	
	public List<Produit> selectAll() {
		return pDao.findAll();
	}
}