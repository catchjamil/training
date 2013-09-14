package com.sd.training.struts2.dao;

import com.sd.training.struts2.bean.User;

public interface LoginDao {

	public User getUserByName(String uname);
}
