package com.ex5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Cama;

public interface CamaRepository extends JpaRepository<Cama, Long> {}
