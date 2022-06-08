package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(" >> TennisCoach :  inside default constructor ");
	}
	
	// 73-consturctor injection
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		
		System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
		
		fortuneService=theFortuneService;
	}
	
	/*
	@Autowired 
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(" >> TennisCoach :  inside doSomeCrazyStuff() method ");
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService; 
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
