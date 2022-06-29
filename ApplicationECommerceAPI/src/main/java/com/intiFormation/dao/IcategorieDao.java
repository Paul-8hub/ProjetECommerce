package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intiFormation.entity.Categorie;

public interface IcategorieDao extends JpaRepository<Categorie, Integer> {
	
	public Categorie save(Categorie c);

	public void deleteById(int id);
	
	public Categorie findById(int idCat);
	public Categorie findByNomCategorie(String nomCategorie);
	
	public List<Categorie> findAll();
}