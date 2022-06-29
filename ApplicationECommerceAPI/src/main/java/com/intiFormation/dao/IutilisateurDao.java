package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;

public interface IutilisateurDao extends JpaRepository<Utilisateur, Integer>{

	public Utilisateur save(Utilisateur u);
	public Utilisateur findByLogin(String login);
	public Utilisateur findByRole(Role role);
}