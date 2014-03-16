package com.sd.training.struts2.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	public static Session openSession() {
		SessionFactory sessionFactory = ApplicationContext.getSessionFactory();
		return sessionFactory.openSession();
	}
}
