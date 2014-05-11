package com.sd.training.struts2.service;

import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.bean.User;

public interface UserService {

	public User save(User user) throws RuntimeException;
	public boolean validuname(User user);
	public Account getAccountNo(Account account);
}
