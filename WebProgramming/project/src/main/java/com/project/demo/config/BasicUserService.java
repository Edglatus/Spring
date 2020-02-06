package com.project.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.demo.model.Authorization;
import com.project.demo.model.BaseUser;
import com.project.demo.repository.BaseUserRepository;

@Service
public class BasicUserService implements UserDetailsService {
	@Autowired
	private BaseUserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String uN) throws UsernameNotFoundException {
		BaseUser user = this.repo.findByUsername(uN);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}		
		
		return new User(user.getUsername(), user.getPassword(), this.authorities(user.getAuthorizations()));
	}
	
	public List<? extends GrantedAuthority> authorities(List<Authorization> input) {
		List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
		
		for (Authorization a : input) {
			auths.add(new SimpleGrantedAuthority("ROLE_" + a.getName()));
		}
		
		return auths;
	}
}
