package com.greatlearning.EmployeeManagement.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.service.EmployeeExistService;

@RestController
@RequestMapping("/existService")
public class EmployeeExistController {
	@Autowired
	EmployeeExistService existService;
	
	@GetMapping("/checkEmployeeExistsById")
	public Optional<Employee> checkEmployeeExistsById(int id) {
		return existService.checkEmployeeExistsById(id);
	}
	
	@GetMapping("/checkEmployeeExistsByFirstName")
	public List<Employee> checkEmployeeExistsByFirstName(String firstName) {
		return existService.checkEmployeeExistsByFirstName(firstName);
	}
	
}

