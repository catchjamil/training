package com.sd.training.struts2.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.MenuDao;
import com.sd.training.struts2.util.HibernateUtil;

public class MenuDaoImpl implements MenuDao {

	@Override
	public List<Menu> menuList(User user) throws RuntimeException {
		Session session = HibernateUtil.openSession();
		
		 int roleId = user.getRoleID();
		 Query createQuery = session.createQuery("from Role where Id="+roleId);
		 List<Role> list = (List<Role>)createQuery.list();
		 Role role = new Role();
		 if(list != null && list.size() >0){
			 role = list.get(0);
		 }
		 List<Menu> menuList = new ArrayList<Menu>();
		 for(Menu menu : role.getMenu()){
			 menuList.add(menu);
		 }
		session.close();
	return 	menuList;

	}

	@Override
	public Menu save(Menu menu)throws RuntimeException {
		try {
			Session session=HibernateUtil.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(menu);
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		return null;
		}
		return menu;
	}

	@Override
	public List<Menu> getMenuList() {
		Session session = HibernateUtil.openSession();
		 Query createQuery = session.createQuery("from Menu");
		List<Menu> menus = new ArrayList<Menu>();
		 List<?> list = createQuery.list();
		 for(Object o:list){
			 menus.add((Menu)o);
		 }
		
		session.close();
	return menus;	
	}

	


}
