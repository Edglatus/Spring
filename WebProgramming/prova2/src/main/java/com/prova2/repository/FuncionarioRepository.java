package com.prova2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova2.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{}
