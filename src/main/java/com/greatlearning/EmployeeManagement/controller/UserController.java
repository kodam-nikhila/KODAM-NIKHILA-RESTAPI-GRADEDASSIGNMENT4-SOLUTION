package com.greatlearning.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.model.User;
import com.greatlearning.EmployeeManagement.service.AuthorityRoleService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	AuthorityRoleService usersService;

	@PostMapping("/addNewUser")
	public User addNewUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("role_name") String role_name) {
		return usersService.addNewUser(username, password, role_name);
	}

}
