package com.sd.training.struts2.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.PasswordDao;
import com.sd.training.struts2.util.HibernateUtil;

public class PasswordDaoImp  implements PasswordDao{

	 public User save(User user) {
		try{
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Query createQuery = session.createQuery("from User where username ='"+user.getUname()+"'");
        List<?> list = createQuery.list();
		if(list != null && list.size() != 0){
			Object object = list.get(0);
			User user2 = (User)object;
			user2.setPassword(user.getPassword());
			session.saveOrUpdate(user2);
		}
		transaction.commit();
		session.close();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
}	

