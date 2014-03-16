package com.sd.training.struts2.util;

import org.hibernate.SessionFactory;


public class ApplicationContext {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		ApplicationContext.sessionFactory = sessionFactory;
	}

}
