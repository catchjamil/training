package com.sd.training.struts2.serviceImpl;

import java.util.List;

import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.daoimpl.RoleDaoImpl;
import com.sd.training.struts2.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		
		RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
		return roleDaoImpl.getRoles();
	}

}
