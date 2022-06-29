package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IroleService;
import com.intiFormation.service.IutilisateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	IutilisateurService uService;
	@Autowired
	IroleService rService;
	@Autowired
	BCryptPasswordEncoder bc;
	
	@GetMapping("/role")
	public List<Role> selectAllRole() {
		return rService.selectAll();
	}
	
	@PostMapping("/utilisateur/{idRole}")
	public void ajouterUser(@RequestBody Utilisateur utilisateur, @PathVariable("idRole") int idRole) {
				
		utilisateur.setPassword(bc.encode(utilisateur.getPassword()));
		utilisateur.setDateNaissance("00-00-000");
		
		Role r = rService.selectById(idRole);
		utilisateur.setRole(r);
		
		uService.ajouter(utilisateur);
	}
}