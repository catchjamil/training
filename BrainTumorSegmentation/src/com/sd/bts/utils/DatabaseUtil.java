package com.sd.bts.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class DatabaseUtil {
	static SessionFactory buildSessionFactory = new AnnotationConfiguration()
			.configure().buildSessionFactory();
	public static Session getSession() {
		return buildSessionFactory.openSession();
	}
	

}
