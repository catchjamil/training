package com.sd.training.struts2.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.training.struts2.bean.Bic;
import com.sd.training.struts2.dao.BicDao;
import com.sd.training.struts2.util.HibernateUtil;

public class BicDaoImpl implements BicDao {

	@Override
	public Bic save(Bic bic) throws RuntimeException {
		try {
		Session session=HibernateUtil.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(bic);
		transaction.commit();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return bic;
	}

}
