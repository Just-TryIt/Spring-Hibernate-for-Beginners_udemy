package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") // Parent mapping
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm") // Sub mappings(relative)
	public String showForm() {
		return "helloworld-form"; // helloworld-form.jsp 페이지로 이동
	}
	
	// need a controller method to process the HTML form

	@RequestMapping("/processForm") // Sub mappings(relative)
	public String processForm() {
		return "helloworld"; // helloworld.jsp 페이지로 이동
	}
	
	// new a controller method to read form data and
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps(대문자)
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);		
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTree")
	public String processFormVersionTree(
			@RequestParam("studentName") String theName,
			Model model) {
		
		// convert the data to all caps(대문자)
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey My Friend from v3! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);		
		
		return "helloworld";
	}
	
	
}
