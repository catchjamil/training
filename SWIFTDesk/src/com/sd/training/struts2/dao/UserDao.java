package com.sd.training.struts2.dao;

import java.util.List;

import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.bean.User;

public interface UserDao {

	
	public User save(User uname) throws RuntimeException;

	public boolean validuname(User user);

	Account getAccountNo(Account account);
	
}
