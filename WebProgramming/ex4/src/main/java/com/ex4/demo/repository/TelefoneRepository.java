package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {}
