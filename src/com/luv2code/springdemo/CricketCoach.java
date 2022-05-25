package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//add new fields for emailAddress and team
	private String emailAddress;
	private String team;
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}


	//create a no-arg consturctor -> 스프링은 Bean을 참조할 때 이 생성자를 호출할 것
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	
	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
		//크리켓에 볼링이라는 게 있음 대충 공을 던지는 동작같음..
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
		//FourtuneServiec라는 인터페이스의 getFortune()가져옴
	}

}
