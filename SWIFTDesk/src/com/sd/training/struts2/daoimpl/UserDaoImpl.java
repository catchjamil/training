package com.sd.training.struts2.daoimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.UserDao;
import com.sd.training.struts2.util.HibernateUtil;

public class UserDaoImpl implements UserDao {


	@Override
	public User save(User user) {
		try{
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
}