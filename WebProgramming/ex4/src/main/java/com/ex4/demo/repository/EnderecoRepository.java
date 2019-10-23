package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}
