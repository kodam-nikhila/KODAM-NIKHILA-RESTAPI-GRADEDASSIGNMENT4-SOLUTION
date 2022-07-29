package com.greatlearning.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagement.model.Role;
import com.greatlearning.EmployeeManagement.service.AuthorityRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	AuthorityRoleService roleService;

	@PostMapping("/addNewRole")
	public Role addNewRole(@RequestParam String name) {
		return roleService.addNewRole(name);
	}

}




