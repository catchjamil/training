package com.sd.training.struts2.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.training.struts2.bean.Payee;
import com.sd.training.struts2.bean.Transfer;
import com.sd.training.struts2.dao.TransferDao;
import com.sd.training.struts2.util.HibernateUtil;

public class TransferDaoImp implements TransferDao{
	
	private static final Object Payee = null;

	@Override
	public Transfer save(Transfer transfer) throws RuntimeException {
		try {
			Session session=HibernateUtil.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(transfer);
			transaction.commit();
		} catch (Exception e) {
			return null;
		}
		return transfer;
	}
	
	@Override
	public List<Payee> getPayeeList() throws RuntimeException {
		
		Session session=HibernateUtil.openSession();
		Query createQuery = session.createQuery("from Payee");
		List<Payee> arrayList = new ArrayList<Payee>();
		List<?> list = createQuery.list();
		
		for(Object obj:list){
			Payee payee = (Payee)obj;
			arrayList.add(payee);
		
	}
		
		return arrayList;
	}

}
