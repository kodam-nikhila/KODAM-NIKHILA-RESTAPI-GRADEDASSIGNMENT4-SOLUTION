package com.greatlearning.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.service.EmployeeDeleteService;
@RestController
@RequestMapping("/deleteService")
public class EmployeeDeleteController {

	@Autowired
	EmployeeDeleteService deleteservice;
	
	

	@DeleteMapping("/deleteEmployeeById")
	public String deleteemployeeById(int id) {
		return deleteservice.deleteEmployeeById(id);
	}
}
