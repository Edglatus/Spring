package com.ex9.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex9.demo.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> { }
