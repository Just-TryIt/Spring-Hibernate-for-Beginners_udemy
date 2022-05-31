package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

//bean id : thatSillyCoach
@Component("thatSillyCoach") 
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
