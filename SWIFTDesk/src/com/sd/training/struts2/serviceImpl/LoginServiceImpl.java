package com.sd.training.struts2.serviceImpl;

import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.LoginDao;
import com.sd.training.struts2.daoimpl.LoginDaoImpl;
import com.sd.training.struts2.security.Encryt;
import com.sd.training.struts2.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean authenticateUser(User user) {
		LoginDao loginDao = new LoginDaoImpl();
		User userByName = loginDao.getUserByName(user.getUname());


		if (userByName != null){
			String Encrytpass=Encryt.getHash(user.getPassword());
				if(Encrytpass.equals(userByName.getPassword())) {
					user.setRoleID(userByName.getRoleID());
					user.setPassword(null);
					return true;
				}	
				else {
					return false;	
				}	
		} else
			return false;
	}

}
