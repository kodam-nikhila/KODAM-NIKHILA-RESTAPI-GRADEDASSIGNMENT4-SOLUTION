package com.greatlearning.EmployeeManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagement.service.EmployeeCreateService;
@Service
public class EmployeeCreateServiceImpl implements EmployeeCreateService{
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public String addSingleEmployee(Employee employee) {
		employeeRepository.save(employee);
		employeeRepository.flush();
		return "Employee saved";
	}
	
		
	
		
}
	



