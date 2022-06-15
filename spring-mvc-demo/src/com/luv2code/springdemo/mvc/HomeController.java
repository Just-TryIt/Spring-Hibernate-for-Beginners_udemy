package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// 메소드 이름은 아무거나 괜찮음
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
