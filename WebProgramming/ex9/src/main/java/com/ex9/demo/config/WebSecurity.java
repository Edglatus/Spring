package com.ex9.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{	
	@Autowired
	private UserService uS;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST).hasRole("ADMIN")
			.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN", "COMUM")
			.and()
			.formLogin().successForwardUrl("/cliente");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder)throws Exception{
		builder.userDetailsService(uS)				
			.passwordEncoder(new BCryptPasswordEncoder());			
	}
}
