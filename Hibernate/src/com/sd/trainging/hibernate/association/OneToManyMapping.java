package com.sd.trainging.hibernate.association;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.sd.trainging.hibernate.pojo.Marksheet;
import com.sd.trainging.hibernate.pojo.Student;

public class OneToManyMapping {


	public static void main(String[] args) {

		SessionFactory buildSessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		
		
		Session session = buildSessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Set<Marksheet> marksheets = new HashSet<Marksheet>();
		Marksheet marksheet1 = new Marksheet();
		marksheet1.setSemester("Sem 1");
		marksheet1.setEnglish(99);
		marksheet1.setMath(98);
		marksheet1.setScience(78);
		marksheet1.setComputer(89);
		
		Marksheet marksheet2 = new Marksheet();
		marksheet2.setSemester("Sem 2");
		marksheet2.setEnglish(98);
		marksheet2.setMath(98);
		marksheet2.setScience(78);
		marksheet2.setComputer(89);
		
		marksheets.add(marksheet1);
		marksheets.add(marksheet2);
		Student student = new Student();
		student.setName("Name_1");
		student.setRoleNumber(1000L);
		student.setMarksheet(marksheets);
		
		session.save(student);
		
		beginTransaction.commit();
		session.close();
	}
}