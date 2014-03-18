package com.sd.training.struts2.service;

import com.sd.training.struts2.bean.User;



public interface PasswordService {
	
	public User save(User user) throws RuntimeException; 

}
