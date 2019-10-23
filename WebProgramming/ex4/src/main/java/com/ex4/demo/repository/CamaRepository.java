package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Cama;

public interface CamaRepository extends JpaRepository<Cama, Long> {}
