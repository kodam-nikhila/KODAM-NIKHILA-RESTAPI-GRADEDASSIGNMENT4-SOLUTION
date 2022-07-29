package com.greatlearning.EmployeeManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.service.EmployeeReadService;

@RestController
@RequestMapping("/readEmployees")
public class EmployeeReadController {
	
	@Autowired
	EmployeeReadService readService;
	
	@GetMapping("/getAllExistingEmployees")
	public List<Employee> getAllExistingEmployees() {
		return readService.getAllExistingEmployees();
	}
	
	@GetMapping("/getEmployeesCustomSortedByFirstName")
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction direction) {
		return readService.getEmployeesCustomSortedByFirstName(direction);
	}
}
