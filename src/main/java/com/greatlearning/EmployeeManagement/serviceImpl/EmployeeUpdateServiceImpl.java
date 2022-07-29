package com.greatlearning.EmployeeManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagement.service.EmployeeUpdateService;

@Service
public class EmployeeUpdateServiceImpl implements EmployeeUpdateService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public ResponseEntity<Employee> updateEmployee(int id,Employee employee){
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow();
			updateEmployee.setId(employee.getId());
			updateEmployee.setFirstName(employee.getFirstName());
			updateEmployee.setLastName(employee.getLastName());
			updateEmployee.setEmail(employee.getEmail());
			
			employeeRepository.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);
	}
}
