package com.sd.trainging.hibernate.crud;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.sd.trainging.hibernate.pojo.Student;


public class InsertObject {

	public static void main(String[] args) {

		SessionFactory buildSessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Student student = new Student();
		
		for(int a= 1; a<50; a++){
		student.setName("Name_"+a);
		student.setRoleNumber(100L+a);
		student.setAddress("Delhi_"+a);
		
		Session session = buildSessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		//session.save(student);
		beginTransaction.commit();
		session.close();
		}
	}
	
}
