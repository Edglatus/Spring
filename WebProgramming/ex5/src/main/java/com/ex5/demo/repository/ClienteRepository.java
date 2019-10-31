package com.ex5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
