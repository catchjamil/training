package com.sd.training.struts2.dao;

import com.sd.training.struts2.bean.User;

public interface UserDao {

	
	public User save(User uname) throws RuntimeException;
	
}
