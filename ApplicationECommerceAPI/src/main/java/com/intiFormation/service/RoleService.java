package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IroleDao;
import com.intiFormation.entity.Role;

@Service
public class RoleService implements IroleService {
	
	@Autowired
	IroleDao rDao;
	
	public List<Role> selectAll() {
		return rDao.findAll();
	}
	
	public Role selectById(int idRole) {
		return rDao.findById(idRole);
	}
}