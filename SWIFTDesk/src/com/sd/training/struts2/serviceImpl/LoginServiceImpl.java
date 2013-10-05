package com.sd.training.struts2.serviceImpl;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.LoginDao;
import com.sd.training.struts2.daoimpl.LoginDaoImpl;
import com.sd.training.struts2.listener.HibernateListener;
import com.sd.training.struts2.service.LoginService;
import com.sd.training.struts2.util.ApplicationContext;
import com.sd.training.struts2.util.HibernateUtil;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean authenticateUser(User user) {
		LoginDao loginDao = new LoginDaoImpl();
		User userByName = loginDao.getUserByName(user.getUname());

		try {
			listCustomer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (userByName != null
				&& user.getPassword().equals(userByName.getPassword())) {
			return true;
		} else
			return false;
	}

	public String listCustomer() throws Exception {

		Session session = HibernateUtil.openSession();
		Menu menu = (Menu) session.createQuery("from Menu").list();
		session.close();
		return "Sucess";

	}
}
