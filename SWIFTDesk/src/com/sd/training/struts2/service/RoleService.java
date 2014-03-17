package com.sd.training.struts2.service;

import java.util.List;

import com.sd.training.struts2.bean.Role;

public interface RoleService {
	public Role save(Role role);
	public List<Role> getRoleList();
	public List<Role> getRoles();
}
