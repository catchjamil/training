package com.sd.training.struts2.service;

import com.sd.training.struts2.bean.User;

public interface LoginService {

	public boolean authenticateUser(User user);
}
