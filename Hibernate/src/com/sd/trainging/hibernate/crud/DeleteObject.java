package com.sd.trainging.hibernate.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.sd.trainging.hibernate.pojo.Student;


public class DeleteObject {

	public static void main(String[] args) {

		SessionFactory buildSessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		
		
		Session session = buildSessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Query createQuery = session.createQuery("from Student where name = 'Name_28'");
		List list = createQuery.list();
		
		if(list != null && list.size() != 0){
			Object object = list.get(0);
			Student s = (Student)object;
			session.delete(s);
		}
		
		//session.save(student);
		beginTransaction.commit();
		session.close();
	}
	
}
