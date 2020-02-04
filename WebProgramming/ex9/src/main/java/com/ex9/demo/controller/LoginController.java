package com.ex9.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {	
	@GetMapping("/login")
	public ModelAndView loginPage() {
	    return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public String loginProcessPage() {
	    return "redirect:/home";
	}
}
