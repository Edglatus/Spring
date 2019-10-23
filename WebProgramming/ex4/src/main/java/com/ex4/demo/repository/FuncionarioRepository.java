package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {}
