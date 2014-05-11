package com.sd.training.struts2.serviceImpl;

import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.LoginDao;
import com.sd.training.struts2.daoimpl.LoginDaoImpl;
import com.sd.training.struts2.security.Encryt;
import com.sd.training.struts2.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public User authenticateUser(User user) {
		LoginDao loginDao = new LoginDaoImpl();
		User userByName = loginDao.getUserByName(user.getUname());


		if (userByName != null){
			String Encrytpass=Encryt.getHash(user.getPassword());
				if(Encrytpass.equals(userByName.getPassword())) {
					userByName.setPassword(null);
					return userByName;
				}	
				else {
					return null;	
				}	
		} else
			return null;
	}

}
