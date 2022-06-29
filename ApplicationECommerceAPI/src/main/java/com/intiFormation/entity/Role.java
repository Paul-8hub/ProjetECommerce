package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String libRole;
	@Column(name="descRole")
	private String description;
	
	@OneToMany(mappedBy = "role")
	private List<Utilisateur> utilisateur;
		
	public Role(int idRole, String libRole, String description) {
		super();
		this.idRole = idRole;
		this.libRole = libRole;
		this.description = description;
	}
	
	public Role(String libRole, String description) {
		super();
		this.libRole = libRole;
		this.description = description;
	}
	
	public Role() {
		super();
	}
	
	public int getIdRole() { return idRole; }
	public String getLibRole() { return libRole; }
	public String getDescription() { return description; }

	public void setIdRole(int idRole) { this.idRole = idRole; }
	public void setLibRole(String libRole) { this.libRole = libRole; }
	public void setDescription(String description) { this.description = description; }

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", libRole=" + libRole + ", description=" + description + "]";
	}
}
