package com.ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex3.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{}