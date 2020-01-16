package com.ex6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex6.demo.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> { }
