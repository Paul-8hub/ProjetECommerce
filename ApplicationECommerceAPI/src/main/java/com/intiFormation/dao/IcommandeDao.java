package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intiFormation.entity.Commande;

public interface IcommandeDao extends JpaRepository<Commande, Integer> {
	
	public Commande save(Commande c);
	
	public void deleteById(int id);
	
	public List<Commande> findAll();

}