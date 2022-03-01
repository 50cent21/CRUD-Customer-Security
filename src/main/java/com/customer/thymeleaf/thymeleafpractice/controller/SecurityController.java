package com.customer.thymeleaf.thymeleafpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {	
		
	    return "access-denied";
	}

}
