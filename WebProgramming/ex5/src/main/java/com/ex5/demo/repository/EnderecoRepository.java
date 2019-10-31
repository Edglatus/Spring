package com.ex5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}
