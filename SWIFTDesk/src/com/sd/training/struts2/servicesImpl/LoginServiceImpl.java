package com.sd.training.struts2.servicesImpl;

import com.sd.training.struts2.services.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public boolean authenticateUser(String userName, String userPwd) {
		if(userName.equals("admin") && userPwd.equals("admin"))
		{
			return true;
		}else 
			return false;
	}
}


