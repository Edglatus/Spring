package com.prova2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByUsername(String username);
}
