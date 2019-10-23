package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}
