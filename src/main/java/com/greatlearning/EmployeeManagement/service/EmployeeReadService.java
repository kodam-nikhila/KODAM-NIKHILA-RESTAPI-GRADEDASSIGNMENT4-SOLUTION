package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.EmployeeManagement.model.Employee;

public interface EmployeeReadService {
	
	List<Employee> getAllExistingEmployees();

	List<Employee> getEmployeesCustomSortedByFirstName(Direction direction);

	

}
