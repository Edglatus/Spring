package com.prova2.config;

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

import com.prova2.model.Permissao;
import com.prova2.model.Usuario;
import com.prova2.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario found = repo.findByUsername(username);
		
		UserDetails user = new User(found.getUsername(), found.getPassword(), getAuths(found.getPermissoes()));
		
		return user;
	}
	
	public List<? extends GrantedAuthority> getAuths(List<Permissao> permissoes) {
		ArrayList<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
		
		for (Permissao p : permissoes) {
			auths.add(new SimpleGrantedAuthority("ROLE_" + p.getNome()));
		}
		
		return auths;
	}

}
