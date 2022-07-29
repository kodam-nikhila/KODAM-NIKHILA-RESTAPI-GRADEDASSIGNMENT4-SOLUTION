package com.greatlearning.EmployeeManagement.security;


import javax.sql.DataSource;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.EmployeeManagement.service.EmployeeUserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		AuthenticationProvider authenticationProvider = customAuthenticationProvider();
		auth.authenticationProvider(authenticationProvider);
		


	}
	@Bean
	public UserDetailsService customUserDetailsService() {
		return new EmployeeUserDetailsService();
	}
	

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider customAuthenticationProvider() {
		
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		
		daoProvider.setUserDetailsService(customUserDetailsService());
		daoProvider.setPasswordEncoder(getPasswordEncoder() );
		
		return daoProvider;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/createService/addSingleEmployee", "/deleteService/deleteEmployeeById",
						"/updateService/updateEmployee")
				.hasAuthority("ADMIN")
				
				  .antMatchers("/readEmployees/getAllExistingEmployees",
				  "/readEmployees/getEmployeesCustomSortedByFirstName", "/existService/checkEmployeeExistsById",
				 "/existService/checkEmployeeExistsByFirstName") .hasAnyAuthority("ADMIN",
				  "USER")
				  .anyRequest().authenticated()
				  .and()
				  .formLogin().loginProcessingUrl("/login").successForwardUrl("/").permitAll()
				  .and()
				  .logout().logoutSuccessUrl("/login").permitAll()
				  .and()
				  .cors().and().csrf().disable();
	}

}
