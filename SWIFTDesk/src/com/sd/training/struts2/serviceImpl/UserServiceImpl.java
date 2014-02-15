package com.sd.training.struts2.serviceImpl;

import org.hibernate.Session;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.UserDao;
import com.sd.training.struts2.daoimpl.UserDaoImpl;
import com.sd.training.struts2.security.Encryt;
import com.sd.training.struts2.service.UserService;
import com.sd.training.struts2.util.HibernateUtil;

public class UserServiceImpl implements UserService {

	@Override
	public User save(User user) {
		UserDao userDao = new UserDaoImpl();
		String s = user.getPassword();
		s= Encryt.getHash(s);
		user.setPassword(s);
		user = userDao.save(user);
		return user;
	}
	
	public String listCustomer() throws Exception {

		Session session = HibernateUtil.openSession();
		Menu menu = (Menu) session.createQuery("from Menu").list();
		session.close();
		return "Sucess";

	}
	
	
	
 		

}
