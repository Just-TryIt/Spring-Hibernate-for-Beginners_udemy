package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;


public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			Instructor tempInstructor =
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code!!!"); 
			
			// associate the objects(객체들을 연결)
			// 객체들이 메모리에 연결됨, 실제로 db에 저장하려면 추가적인 과정을 거쳐야됨
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			

			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
