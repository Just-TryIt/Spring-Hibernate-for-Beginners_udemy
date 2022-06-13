package com.luv2code.springdemo;

public class SwinCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwinCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
