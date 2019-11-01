package com.ex5.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	public List<Funcionario> findBySetor(String setor);
}
