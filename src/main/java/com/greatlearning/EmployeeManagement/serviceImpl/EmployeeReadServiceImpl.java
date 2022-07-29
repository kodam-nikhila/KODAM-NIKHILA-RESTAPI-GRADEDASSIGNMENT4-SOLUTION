package com.greatlearning.EmployeeManagement.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagement.service.EmployeeReadService;

@Service
public class EmployeeReadServiceImpl implements EmployeeReadService {
	@Autowired
	EmployeeRepository readRepository;
	
	public List<Employee> getAllExistingEmployees() {
		return readRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction direction) {
	
		return readRepository.findAll(Sort.by(direction, "firstName"));
	}
	
}
