package com.greatlearning.EmployeeManagement.service;

import org.springframework.http.ResponseEntity;

import com.greatlearning.EmployeeManagement.model.Employee;

public interface EmployeeUpdateService {

	ResponseEntity<Employee> updateEmployee(int id, Employee employee);

}