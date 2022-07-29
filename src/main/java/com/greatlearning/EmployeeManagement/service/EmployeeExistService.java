package com.greatlearning.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.EmployeeManagement.model.Employee;

public interface EmployeeExistService {
	

	Optional<Employee> checkEmployeeExistsById(int id);

	List<Employee> checkEmployeeExistsByFirstName(String firstName);

}

