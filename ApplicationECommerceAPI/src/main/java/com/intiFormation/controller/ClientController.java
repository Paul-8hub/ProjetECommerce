package com.intiFormation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.LignePanier;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Produit;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IcategorieService;
import com.intiFormation.service.IproduitService;
import com.intiFormation.service.IutilisateurService;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
	
	@Autowired
	IutilisateurService uService;
	@Autowired
	IproduitService pService;
	@Autowired
	IcategorieService cService;
	/*@Autowired
	IcommandeService coService;
	@Autowired
	IlignecommandeService lcService;*/
	
	@GetMapping("/produit")
	public List<Produit> afficherProduit() {
		return pService.selectAll();
	}
	
	@GetMapping("/categorie")
	public List<Categorie> AfficherCategorie(Model model) {
		List<Categorie> ListC = cService.selectAll();
		return ListC;
	}
	
	@GetMapping("/produit/{r}")
	public List<Produit> chercherProduit(@PathVariable("r") String recherche, HttpSession s) {
		
		//------------ Création du panier ---------------
		Panier panier2 = (Panier) s.getAttribute("panier");
		if (panier2==null) {
			Panier p = new Panier(1);
			int id = 1;
			s.setAttribute("panier", p);
			s.setAttribute("id", id);
		}
		
		return pService.selectByLibProduit(recherche);
	}
	
	//-------------------------------- Panier --------------------------------
	// 1 - Recherche d'un produit (ci-dessus)
	// 2 - Création du panier (=ajout des produits au panier) (juste en bas)
	// 3 - Affichage du panier si on veut (plus bas)
	@PostMapping("/panier")
	public void ajouterProduitPanier(HttpSession s, @RequestParam("idProduit") int idProduit, @RequestParam("quantite") int quantite) {
		Produit p = pService.selectById(idProduit);
		
		// Pour que la méthode marche il faut que le panier soit créé dans la session
		Panier panier = (Panier) s.getAttribute("panier");
		int id = (Integer) s.getAttribute("id");
		
		LignePanier lp = new LignePanier(id,panier,p,quantite);
		System.out.println("liste des produits selectionnes :" + lp);
	
		panier.getLignePanier().add(lp);
		s.setAttribute("id", id+1);

		// Utilisé pour renvoyer les lignes du panier à la page suivante
		//List<LignePanier> ListLP = panier.getLignePanier();
		//s.setAttribute("ListLP", ListLP);
	}
	
	@GetMapping("/panier")
	public List<LignePanier> voirPanier(HttpSession s) {
		Panier panier = (Panier) s.getAttribute("panier");
		List<LignePanier> ListLP = panier.getLignePanier();
		return ListLP;
	}
	
	@DeleteMapping("/panier/{id}")
	public void SupprimerLignePanier(HttpSession s, @PathVariable("id") int idLignePanier) {
		Panier panier = (Panier) s.getAttribute("panier");
		List<LignePanier> ListLP = panier.getLignePanier();

		for(int i=0;i<ListLP.size();i++) {
			if(ListLP.get(i).getIdLignePanier()==idLignePanier) {
				panier.getLignePanier().remove(ListLP.get(i));
			}
		}
	}
	
	//Essayer de rentrer les données sur postman avec le tableau ou en raw, essayer les deux méthodes.
	@PutMapping("/panier")
	public void ModifierLignePanier(HttpSession s, @RequestParam("idLignePanier") int idLignePanier, @RequestParam("quantite") int quantite) {
		Panier panier = (Panier) s.getAttribute("panier");
		List<LignePanier> ListLP = panier.getLignePanier();	
		
		for(int i=0;i<ListLP.size();i++) {
			if(ListLP.get(i).getIdLignePanier()==idLignePanier) {
				ListLP.get(i).setQuantite(quantite);
			}
		}
	}
	
	
	
	
	
	
	
	//-------------------------------- Commande --------------------------------
	/*@RequestMapping("/Commander")
	public String commander(HttpSession s, Authentication auth, Model m) {
		String login=((User)auth.getPrincipal()).getUsername();
		Utilisateur u = uService.chercherParLogin(login);
		
		Panier panier = (Panier) s.getAttribute("panier");
		List<LignePanier> ListLP = panier.getLignePanier();
		List<LigneCommande> ListLC = new ArrayList<LigneCommande>();
		
		LocalDate date = LocalDate.now()/*.format(DateTimeFormatter.ofPattern("dd/mm/yyyy"))*/;
		
		/*System.out.println(date);
		Commande commande = new Commande(date, u);
		
		for(int i=0;i<ListLP.size();i++) {
			Produit nouvP = ListLP.get(i).getProduit();
			nouvP.setQuantite(nouvP.getQuantite()-ListLP.get(i).getQuantite());
			System.out.println(nouvP);
			pService.ajouter_modifier(nouvP);
			
			LigneCommande lc = new LigneCommande(commande, ListLP.get(i).getProduit(), ListLP.get(i).getQuantite());
			ListLC.add(lc);
		}
		commande.setLigneCommandes(ListLC);
		coService.ajouter(commande);
		s.setAttribute("panier", null);
		
		for(int i=0;i<ListLC.size();i++) {
			lcService.ajouter(ListLC.get(i));
		}
		return "redirect:/client/";
	}*/
}