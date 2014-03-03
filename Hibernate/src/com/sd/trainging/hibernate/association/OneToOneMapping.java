package com.sd.trainging.hibernate.association;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.sd.trainging.hibernate.pojo.Student;
import com.sd.trainging.hibernate.pojo.StudentDetails;

public class OneToOneMapping {


	public static void main(String[] args) {

		SessionFactory buildSessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		
		
		Session session = buildSessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setBranchID(12L);
		studentDetails.setStudentCurrentYear("29/30/12");
		studentDetails.setFatherName("Father Name");
		Student student = new Student();
		student.setName("Name");
		student.setRoleNumber(1000L);
		student.setStudentDetails(studentDetails);
		session.save(student);
		
		beginTransaction.commit();
		session.close();
	}
	


}
