package com.greatlearning.EmployeeManagement.controller;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagement.service.EmployeeUpdateService;


@RestController
@RequestMapping("/updateService")
public class EmployeeUpdateController {
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	
	@PostMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(int id, Employee employee){
		return employeeUpdateService.updateEmployee(id, employee);
		
	}
	
	


}
