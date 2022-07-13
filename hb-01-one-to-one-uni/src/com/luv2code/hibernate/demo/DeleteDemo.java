package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;


public class DeleteDemo {

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
			
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key
			// primary key 또는 ID로 강사 가져오기
			int theId=1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);  // 찾지 못하면 null을 반환함
			
			System.out.println("Found Instructor : "+tempInstructor);
			
			// delete the instructors ★
			if (tempInstructor != null) {
				System.out.println("Deleting : "+tempInstructor);
				
				// Note : will ALSO delete associated "details" object
				// bacause of CascadeType.ALL
				
				// deails 객체도 삭제된다. 왜? -> CascadeType.ALL로  설정되어 있기 때문!
				// 실제 object도 삭제
				session.delete(tempInstructor);
			}
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
