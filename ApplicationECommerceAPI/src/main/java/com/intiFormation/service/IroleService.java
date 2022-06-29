package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Role;

public interface IroleService {

	public List<Role> selectAll();
	public Role selectById(int idRole);
}
