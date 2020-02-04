package com.ex9.demo.config;

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
public class WebSecurity extends WebSecurityConfigurerAdapter{	
	@Autowired
	private UserService uS;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/cliente/*", "user/*").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "*/alterar/*", "*/excluir/*", "*/cadastrar/*", "user/*").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/cliente", "/images", "/files").hasAnyRole("ADMIN", "COMUM")
			.antMatchers(HttpMethod.GET, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
            .usernameParameter("username")
            .passwordParameter("password");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder)throws Exception{
		builder.userDetailsService(uS)				
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}

