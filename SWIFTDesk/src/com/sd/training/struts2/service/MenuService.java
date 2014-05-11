package com.sd.training.struts2.service;

import java.util.List;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.bean.User;

public interface MenuService {
	public List<Menu> menuList(User user)throws RuntimeException;
	public Menu save(Menu menu)throws RuntimeException;
	public List<Menu> getMenuList();
	public List<Menu> getMenuList(List menuIdList);
	public List<Menu> getMenuIdList(long id);
	public List<Role> getRoleList();
	public List<Menu> getCurrentMenu(long id);
}
