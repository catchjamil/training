package com.sd.training.struts2.serviceImpl;

import java.util.List;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.MenuDao;
import com.sd.training.struts2.daoimpl.MenuDaoImpl;
import com.sd.training.struts2.service.MenuService;

public class MenuServiceImpl implements MenuService {

	@Override
	public List<Menu> menuList(User user) throws RuntimeException {
	  MenuDao menuDao = new MenuDaoImpl();
	  return menuDao.menuList(user);
	}

	@Override
	public Menu save(Menu menu) throws RuntimeException {
		MenuDao menuDao=new MenuDaoImpl();
		menu=menuDao.save(menu);
	
		return menu;
	}

	@Override
	public List<Menu> getMenuList() {
		 MenuDao menuDao = new MenuDaoImpl();
		  return menuDao.getMenuList();
	}

	@Override
	public List<Role> getRoleList() {
		 MenuDao menuDao = new MenuDaoImpl();
		  return menuDao.getRoleList();
	}

		
}
