package com.sd.training.struts2.daoimpl;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.dao.PayeeDao;
import com.sd.training.struts2.util.HibernateUtil;

public class PayeeDaoImpl implements PayeeDao {

	

	@Override
	public Payee save(Payee payee) throws RuntimeException {
		try {
			Session session=HibernateUtil.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(payee);
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		return null;
		}
		return payee;
	}

	
	
	
}

		

