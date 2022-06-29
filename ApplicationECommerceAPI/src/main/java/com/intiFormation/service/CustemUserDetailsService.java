package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;


@Service("us")
public class CustemUserDetailsService implements UserDetailsService {
	
	@Autowired
	IutilisateurService utilisateurService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Utilisateur utilisateur=utilisateurService.chercherParLogin(username);
		
		if(utilisateur==null)
		{
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> listeRole=getGrantedAuthority(utilisateur);
		
		return  new User(utilisateur.getLogin(), utilisateur.getPassword(),listeRole );
		
	}
	
	
	private List<GrantedAuthority>  getGrantedAuthority(Utilisateur u)
	{
		List<GrantedAuthority> liste=new ArrayList<>();
		Role role=u.getRole();
		//System.out.println(role.getNom());
		liste.add(new SimpleGrantedAuthority(role.getLibRole()));
		return liste;
		
	}
	
	

}
