package com.ex6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex6.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { }
