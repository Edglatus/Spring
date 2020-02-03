package com.project.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.successForwardUrl("/produtos")
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "*/create/*", "*/alter/*", "*/delete/*").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.POST, "*/create/*", "*/alter/*", "*/delete/*", "/image").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/products/*", "/login", "/image/*").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll();
	}
}
