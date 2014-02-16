package com.sd.training.struts2.dao;

import java.util.List;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;

public interface MenuDao {

	
	public List<Menu> menuList(User user) throws RuntimeException;
	
}
