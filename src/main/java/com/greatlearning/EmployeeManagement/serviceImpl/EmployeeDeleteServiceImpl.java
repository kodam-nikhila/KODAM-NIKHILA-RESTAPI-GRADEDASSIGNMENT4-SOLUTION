package com.greatlearning.EmployeeManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagement.service.EmployeeDeleteService;

@Service
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "Employee with id: "+id+" is deleted";
	}
}
