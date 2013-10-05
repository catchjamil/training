package com.sd.training.struts2.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sd.training.struts2.util.ApplicationContext;
 
public class HibernateListener implements ServletContextListener{
 
    private SessionFactory factory;
    private static Class clazz = HibernateListener.class;
 
    public static final String KEY_NAME = clazz.getName();
 
	public void contextDestroyed(ServletContextEvent event) {
	  //
	}
 
	public void contextInitialized(ServletContextEvent event) {
 
	 try { 
	        
	        factory = new AnnotationConfiguration().configure().buildSessionFactory();
	        ApplicationContext.setSessionFactory(factory);	
	        //save the Hibernate session factory into serlvet context
	        event.getServletContext().setAttribute(KEY_NAME, factory);
	  } catch (Exception e) {
	         System.out.println(e.getMessage());
	   }
	}
}