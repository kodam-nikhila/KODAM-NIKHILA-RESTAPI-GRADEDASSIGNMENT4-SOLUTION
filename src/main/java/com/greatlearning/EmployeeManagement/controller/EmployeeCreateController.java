package com.greatlearning.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.model.Employee;

import com.greatlearning.EmployeeManagement.service.EmployeeCreateService;



@RestController
@RequestMapping("/createService")
public class EmployeeCreateController {
	@Autowired
	EmployeeCreateService createService;
		
	@PostMapping("/addSingleEmployee")
	public String addSingleEmployee(Employee employee) {
		return createService.addSingleEmployee(employee);
	}
	

	
	
	
}


