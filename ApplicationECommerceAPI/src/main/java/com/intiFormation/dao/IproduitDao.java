package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intiFormation.entity.Produit;

public interface IproduitDao extends JpaRepository<Produit, Integer> {
	
	public Produit save(Produit p);
	
	/*@Query("UPDATE Produit p SET p.nomProduit=:nomP, p.imgProduit=:imgP, p.qteProdDispo=:quantite, p.idCat=:idCat WHERE p.idProduit=:idProduit")
	public Produit modifier(@Param("nom") String nomP, @Param("imgP") String imgP, @Param("quantite") int quantite, @Param("idProduit") int idProduit);*/
	
	public void deleteById(int id);
	
	public Produit findById(int idProduit);
	public List<Produit> findByLibProduit(String libProduit);
	public List<Produit> findByCategorie_idCategorie(int idCat);
	
	public List<Produit> findAll();
}