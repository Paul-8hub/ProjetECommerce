package com.intiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.IcategorieService;
import com.intiFormation.service.IproduitService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {

	@Autowired
	IproduitService pService;
	@Autowired
	IcategorieService cService;
	
	@GetMapping("/produit")
	public List<Produit> afficherProduit() {
		return pService.selectAll();
	}
	
	@GetMapping("/produit/{id}")
	public Produit selectProduitById(@PathVariable("id") int id) {
		Produit p = pService.selectById(id);
		//System.out.println(p.getLibProduit());
		return p;
	}
	
	@GetMapping("/produitParCat/{idCat}")
	public List<Produit> selectProduitByIdCat(@PathVariable("idCat") int idCategorie) {
		// Categorie c = cService.selectById(idCategorie);
		List<Produit> ListP = pService.selectByIdCat(idCategorie);
		return ListP;
	}
	
	@PostMapping("/produit")
	public void ajouterProduit(@RequestParam("idCat") int idCategorie, 
			@RequestParam("libProduit") String libProduit, 
			@RequestParam("file") MultipartFile file,
			@RequestParam("quantite") int quantite,
			HttpSession session) {
		
		String filename = file.getOriginalFilename();
		String Temp = session.getServletContext().getRealPath("/");
		String path = Temp+"images\\"+filename;
		Produit produit = new Produit();
				
		produit.setImg("\\images\\"+filename);
		produit.setLibProduit(libProduit);
		produit.setQuantite(quantite);
		produit.setCategorie(cService.selectById(idCategorie));
		
		pService.ajouter_modifier(produit);
		System.out.println("Le produit a été ajouté");
		
		//System.out.println(path);
		
		try {
			byte TabBytes[]=file.getBytes();
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path));
			bout.write(TabBytes);
			bout.flush();
			bout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/produit/{id}")
	public void modifierProduit(HttpSession s, @PathVariable("id") int idProduit, 
			@RequestParam("idCat") int idCategorie,
			@RequestParam("libProduit") String libProduit, 
			@RequestParam("quantite") int quantite, 
			@RequestParam("file") MultipartFile file) {
		String filename = file.getOriginalFilename();
		String path = s.getServletContext().getRealPath("/")+"images\\"+filename;
		Produit p = new Produit();
		
		p.setIdProduit(idProduit);
		p.setImg("\\images\\"+filename);
		p.setLibProduit(libProduit);
		p.setQuantite(quantite);
		p.setCategorie(cService.selectById(idCategorie));		
		pService.ajouter_modifier(p);
	}
	
	// Modification d'un produit dans le cas où il n'y a pas de fichier sélectionné
	@PutMapping("/produitssF/{id}")
	public void modifierProduitssFichier(HttpSession s, @PathVariable("id") int idProduit, 
			@RequestParam("idCat") int idCategorie,
			@RequestParam("libProduit") String libProduit, 
			@RequestParam("quantite") int quantite) {
		Produit pSansF = selectProduitById(idProduit);
		
		pSansF.setIdProduit(idProduit);
		pSansF.setLibProduit(libProduit);
		pSansF.setQuantite(quantite);
		pSansF.setCategorie(cService.selectById(idCategorie));		
		pService.ajouter_modifier(pSansF);
	}
	
	@DeleteMapping("/produit/{id}")
	public void supprimerProduit(@PathVariable("id") int id) {
		pService.supprimer(id);	
	}
}