package com.sd.training.struts2.serviceImpl;

import java.util.List;

import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.dao.RoleDao;
import com.sd.training.struts2.daoimpl.RoleDaoImpl;
import com.sd.training.struts2.service.RoleService;

public class RoleServiceImpl implements RoleService{

	@Override
	public Role save(Role role) {
		RoleDao roleDao = new RoleDaoImpl();
		//Role role=null;
		
			role=roleDao.setData(role);
	
		return role;
	}

	@Override
	public List<Role> getRoleList() {
		RoleDao roleDao = new RoleDaoImpl();
	   List<Role> list=roleDao.getRoleList();
		return list;
	}

	@Override
	public List<Role> getRoles() {
		RoleDao roleDao = new RoleDaoImpl();
		   List<Role> list=roleDao.getRoles();
			return list;
	}
	
}
