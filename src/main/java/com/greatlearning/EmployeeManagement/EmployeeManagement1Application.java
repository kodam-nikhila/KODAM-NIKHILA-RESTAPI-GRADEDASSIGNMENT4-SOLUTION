package com.greatlearning.EmployeeManagement;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.EmployeeManagement.model.Role;
import com.greatlearning.EmployeeManagement.model.User;
import com.greatlearning.EmployeeManagement.repository.UserRepository;

@SpringBootApplication
public class EmployeeManagement1Application implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagement1Application.class, args);
		System.out.println("hi kodam");
		System.out.println("hi nikhila");
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		 User user = new User();
		  
		  user.setId(1); user.setUsername("nikhila"); user.setPassword(new
		  BCryptPasswordEncoder().encode("nikhila"));
		  
		  List<Role> roles = new ArrayList<>(); roles.add(new Role(1,"ADMIN"));
		  user.setRoles(roles);
		  
		  userRepository.save(user);
		 
		
	}

}


