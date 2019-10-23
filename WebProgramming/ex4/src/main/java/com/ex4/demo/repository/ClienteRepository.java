package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
