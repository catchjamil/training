package com.sd.training.struts2.dao;

import com.sd.training.struts2.bean.User;



public interface PasswordDao {
	
	public User save(User user) throws RuntimeException;

}
