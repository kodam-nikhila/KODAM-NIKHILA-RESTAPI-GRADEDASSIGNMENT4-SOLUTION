package com.greatlearning.EmployeeManagement.serviceImpl;



import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagement.service.EmployeeExistService;

@Service
public class EmployeeExistServiceImpl implements EmployeeExistService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Optional<Employee> checkEmployeeExistsById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> checkEmployeeExistsByFirstName(String firstName) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("lastName", "id","email");
		Example example = Example.of(employee, exampleMatcher);
		return employeeRepository.findAll(example);
	}

	
	}





