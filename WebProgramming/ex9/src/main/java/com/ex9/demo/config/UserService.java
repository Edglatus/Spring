package com.ex9.demo.config;

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

import com.ex9.demo.model.Authorization;
import com.ex9.demo.model.Usuario;
import com.ex9.demo.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UsuarioRepository repo;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		
		return new User(user.getUsername(), user.getPass(), 
						authorities(user.getAuthorizations()));
	}
	
	public List<? extends GrantedAuthority> authorities(List<Authorization> l) {
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		
		for(Authorization a : l) {
			list.add(new SimpleGrantedAuthority("ROLE_" + a.getName()));
		}
		
		return list;
	}

}
