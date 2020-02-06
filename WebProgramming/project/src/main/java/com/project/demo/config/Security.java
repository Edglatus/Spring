package com.project.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	@Autowired
	private BasicUserService uS;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(uS)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/**/create", "/**/alter/**", "/**/delete/**", "/users/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/**/create", "/**/alter/**", "/**/delete/**", "/image/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/", "/products", "/login", "/image/**").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.and()
			.formLogin()
			.defaultSuccessUrl("/products");
	}
}
