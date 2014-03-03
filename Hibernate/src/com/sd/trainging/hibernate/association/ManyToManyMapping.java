package com.sd.trainging.hibernate.association;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.sd.trainging.hibernate.pojo.Marksheet;
import com.sd.trainging.hibernate.pojo.Student;
import com.sd.trainging.hibernate.pojo.Teacher;

public class ManyToManyMapping {


	public static void main(String[] args) {

		SessionFactory buildSessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		
		
		Session session = buildSessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Set<Teacher> teachers = new HashSet<Teacher>();
		Teacher teacher1 = new Teacher();
		teacher1.setAddress("haryana");
		teacher1.setDempartmentId(1L);
		teacher1.setName("Name");
		
		Teacher teacher2 = new Teacher();
		teacher2.setAddress("bihar");
		teacher2.setDempartmentId(2L);
		teacher2.setName("Name2");
		
		teachers.add(teacher1);
		teachers.add(teacher2);
		Student student = new Student();
		student.setName("Name_1");
		student.setRoleNumber(1000L);
		student.setTeachers(teachers);
		session.save(student);
		
		beginTransaction.commit();
		session.close();
	}
}