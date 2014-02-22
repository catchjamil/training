package com.sd.training.struts2.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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


	public List<Payee> getAccountList() throws RuntimeException {
		
		Session session=HibernateUtil.openSession();
		Query createQuery = session.createQuery("from Payee");
		ArrayList<Payee> arrayList = new ArrayList<Payee>();
		List list = createQuery.list();
		
		for(Object obj:list){
			Payee payee = (Payee)obj;
			arrayList.add(payee);
		
	}
		
		return arrayList;
	}
	
}

		

