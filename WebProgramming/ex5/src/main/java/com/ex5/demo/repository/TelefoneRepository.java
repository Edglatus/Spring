package com.ex5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {}
