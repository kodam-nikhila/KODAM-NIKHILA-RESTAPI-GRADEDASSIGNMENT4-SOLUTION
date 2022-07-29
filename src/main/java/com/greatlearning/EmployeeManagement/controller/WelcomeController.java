package com.greatlearning.EmployeeManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping("/")
	public String handleWelcome() {
		return "<h1>Welcome to Employee Management</h1>";
	}
	
}
