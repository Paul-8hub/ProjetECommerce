package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Role;

public interface IroleDao extends JpaRepository<Role, Integer> {
	
	public List<Role> findAll();
	public Role findById(int idRole);
}
