package com.sd.training.struts2.serviceImpl;

import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.LoginDao;
import com.sd.training.struts2.daoimpl.LoginDaoImpl;
import com.sd.training.struts2.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean authenticateUser(User user) {
		LoginDao loginDao = new LoginDaoImpl();
		User userByName = loginDao.getUserByName(user.getUname());


		if (userByName != null
				&& user.getPassword().equals(userByName.getPassword())) {
			return true;
		} else
			return false;
	}

}
