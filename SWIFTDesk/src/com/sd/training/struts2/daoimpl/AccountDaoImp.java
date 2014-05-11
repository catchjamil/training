package com.sd.training.struts2.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sd.training.struts2.bean.Account;
import com.sd.training.struts2.bean.Account_number;
import com.sd.training.struts2.bean.Role;
import com.sd.training.struts2.dao.AccountDao;
import com.sd.training.struts2.util.DatabaseUtil;
import com.sd.training.struts2.util.HibernateUtil;

public class AccountDaoImp implements AccountDao {

	@Override
	public Account save(Account account)throws RuntimeException {
		try {
			Session session=HibernateUtil.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(account);
			transaction.commit();
			session.close();
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
			return account;
	}
	@Override
public long getAccNo(){
Connection dbConnection = DatabaseUtil.getDBConnection();
		
	    try { 
			  
			 Statement createStatement = dbConnection.createStatement();
			 ResultSet executeQuery = createStatement.executeQuery("select max(accountnumber) from account");
			 executeQuery.first();
			 long accountno=Long.valueOf(executeQuery.getLong(1));
    		 		System.out.println("Account"+ accountno );
    		 		return accountno;
    			}catch(Exception e){
    				System.out.println("Error ................"+e+e.getStackTrace());
    			}
		return 0;
}
	@Override
public long setAccNo(long l){
	try{
	Session session=HibernateUtil.openSession();
	Transaction transaction=session.beginTransaction();
	Query query=session.createQuery("UPDATE Account_number set accountNo = :a "  + 
             "WHERE id = :a1");
	query.setParameter("a",l);
	query.setParameter("a1", l-1);
	int result = query.executeUpdate();
	transaction.commit();
	session.close();
	}catch(Exception e){
		e.printStackTrace();
		return 0;
	}
	return l;
}
}
