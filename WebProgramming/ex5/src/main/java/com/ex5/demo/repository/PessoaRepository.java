package com.ex5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
