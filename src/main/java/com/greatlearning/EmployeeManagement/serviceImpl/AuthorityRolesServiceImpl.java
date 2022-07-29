package com.greatlearning.EmployeeManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.model.Role;
import com.greatlearning.EmployeeManagement.model.User;
import com.greatlearning.EmployeeManagement.repository.RoleRepository;
import com.greatlearning.EmployeeManagement.repository.UserRepository;
import com.greatlearning.EmployeeManagement.service.AuthorityRoleService;

@Service
public class AuthorityRolesServiceImpl implements AuthorityRoleService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public Role addNewRole(String name) {
		Role role = roleRepository.findRoleByName(name);
		
		if(role != null) {
			return role;
		}else {
			role = new Role();
			role.setName(name);
			return roleRepository.save(role);
		}
	}
	
	public User addNewUser(String username,String password,String role_name) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(new BCryptPasswordEncoder().encode(password));

		List<Role> roles = new ArrayList<>();
		Role role = roleRepository.findRoleByName(role_name);
		if (role == null)
			role = addNewRole(role_name);
		roles.add(role);
		user.setRoles(roles);

		return userRepository.save(user);

	}

	
}
