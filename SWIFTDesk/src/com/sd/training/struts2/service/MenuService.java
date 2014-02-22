package com.sd.training.struts2.service;

import java.util.List;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;

public interface MenuService {
	public List<Menu> menuList(User user)throws RuntimeException;
	public Menu save(Menu menu)throws RuntimeException;

}
