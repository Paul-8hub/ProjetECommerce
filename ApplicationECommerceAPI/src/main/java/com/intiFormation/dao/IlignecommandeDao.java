package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.LigneCommande;

public interface IlignecommandeDao extends JpaRepository<LigneCommande, Integer>{
	
	public LigneCommande save(LigneCommande lc);
	
	public void deleteById(int id);
	
	public List<LigneCommande> findAll();
}