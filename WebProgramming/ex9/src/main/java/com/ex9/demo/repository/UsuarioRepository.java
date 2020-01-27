package com.ex9.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex9.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findByUsername(String username);	
}
