package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form"; // helloworld-form.jsp 페이지로 이동
	}
	
	
	
	// need a controller method to process the HTML form

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld"; // helloworld.jsp 페이지로 이동
	}
	
	
}
