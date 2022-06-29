package com.intiFormation.controller;

import java.util.List;

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

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;
import com.intiFormation.service.IcategorieService;
//import com.intiFormation.service.IproduitService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {
	
	@Autowired
	IcategorieService cService;
	/*@Autowired
	IproduitService pService;*/
	
	@GetMapping("/categorie")
	public List<Categorie> AfficherCategorie(Model model) {
		List<Categorie> ListC = cService.selectAll();
		return ListC;
	}
	
	@GetMapping("/categorie/{id}")
	public Categorie selectCategorieById(@PathVariable("id") int id) {
		Categorie c = cService.selectById(id);
		return c;
	}
	
	@PostMapping("/categorie")
	public void ajouterCategorie(@RequestBody Categorie c) {
		cService.ajouter_modifier(c);
	}
	
	@PutMapping("/categorie")
	public void modifierCategorie(@RequestBody Categorie c) {
		cService.ajouter_modifier(c);
	}
	
	@DeleteMapping("/categorie/{id}")
	public void supprimerCategorie(@PathVariable("id") int id) {
		cService.supprimer(id);
	}
}