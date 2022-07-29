package com.greatlearning.EmployeeManagement.service;

import com.greatlearning.EmployeeManagement.model.Role;
import com.greatlearning.EmployeeManagement.model.User;

public interface AuthorityRoleService {
	Role addNewRole(String name);

	User addNewUser(String username, String password, String role_name);

}

