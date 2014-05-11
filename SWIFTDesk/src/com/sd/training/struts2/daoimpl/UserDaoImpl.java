package com.sd.training.struts2.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.bean.Role;
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
	@Override
	public boolean validuname(User user) {
		
		Session session=HibernateUtil.openSession();
		Query createQuery=session.createQuery("from User where uname=:un");
		createQuery.setParameter("un",user.getUname());
		List<User> list = createQuery.list();
		session.close();
		//user=list.get(0);
	
		if(!list.isEmpty()){
			System.out.println("yes");
		return true;
		}else {
			System.out.println("nooooooooo");
			return false;
		}
	}

	@Override
	public Account getAccountNo(Account account) {
		
		Session session=HibernateUtil.openSession();
		Query createQuery=session.createQuery("from Account where accountnumber=:un");
		createQuery.setParameter("un",account.getAccountnumber());
		List<Account> list = createQuery.list();
		session.close();
		if(!list.isEmpty()){
		account=list.get(0);
		return account;
		}else{
			return null;
		}
		
	}
}