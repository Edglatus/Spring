package com.ex8.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex8.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { }
