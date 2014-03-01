package com.sd.trainging.hibernate.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.sd.trainging.hibernate.pojo.Student;


public class SelectObject {

	public static void main(String[] args) {

		SessionFactory buildSessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		
		Session session = buildSessionFactory.openSession();
		Query createQuery = session.createQuery("from Student");
		List list = createQuery.list();
		
		for(Object object : list){
			Student std = (Student)object;
			System.out.println(std.getId()+" : "+std.getName());
			
		}
		
		session.close();
	}
	
}
