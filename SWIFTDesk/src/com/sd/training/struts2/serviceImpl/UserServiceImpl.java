package com.sd.training.struts2.serviceImpl;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

import org.hibernate.Session;

import com.sd.training.struts2.bean.Menu;
import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.UserDao;
import com.sd.training.struts2.daoimpl.UserDaoImpl;
import com.sd.training.struts2.service.UserService;
import com.sd.training.struts2.util.HibernateUtil;

public class UserServiceImpl implements UserService {

	@Override
	public User save(User user) {
		UserDao userDao = new UserDaoImpl();
		String s = user.getPassword();
		s= getHash(s);
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
	
	
	private String getHash(String password){

        MessageDigest mDigest;
        StringBuffer obj = null;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(password.getBytes());
			 obj = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				obj.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-genercmdated catch block
			e.printStackTrace();
		}
        return obj.toString();
 		
	}
}
