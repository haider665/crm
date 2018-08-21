package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestClass {

	
	@RequestMapping("/")
	public String home(Model model) {
		
		String myName= "MOFIZ MOJIB HAIDER";
		model.addAttribute("name", myName);
		return "home";
	}
	
	
}
