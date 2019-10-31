package com.ex5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}
