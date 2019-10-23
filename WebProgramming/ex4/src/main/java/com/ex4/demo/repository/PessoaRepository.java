package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
