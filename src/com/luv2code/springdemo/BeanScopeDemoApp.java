package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean from spring container
		// Bean 두 개를 가져올 것이다.
		// 스프링 컨테이너에서 bean을 검색하기 위한 코드이다.
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are the same -> boolean변수로 확인
		boolean result = (theCoach == alphaCoach);
		// print out the results
		System.out.println("\nPointing to the same object : " + result);

		// 각자의 메모리 위치를 출력
		System.out.println("\nMemory location for theCoach : " + theCoach);
		System.out.println("\nMemory location for alphaCoach : " + alphaCoach + "\n");
		
		//close the context
		context.close();

	}

}
