package com.ex7.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex7.demo.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> { }
