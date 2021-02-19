package com.example.fleetmanagement.securityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("development")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//Authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("rac") //user name
									 .password("{noop}secret") //temp password
		                             .roles("USER","ADMIN"); //roles user has									
	}	
	
	//Authorization
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.antMatcher("/**").authorizeRequests()
							  .anyRequest().hasRole("USER") //for any request, user must have a role
							  .and()
							  .formLogin().loginPage("/login.jsp")
							  			  .failureUrl("/login.jsp?error=1")
							  			  .loginProcessingUrl("/login")
							  			  .permitAll()
							  			  .and()
							  			  .logout()
							  			  .logoutSuccessUrl("/website/vehicles/list.html"); //when logout, redirect to this page
												  
		
	}

}
