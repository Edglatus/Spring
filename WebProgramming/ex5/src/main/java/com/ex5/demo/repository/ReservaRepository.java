package com.ex5.demo.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	public List<Reserva> findByIDs(long cliente, long funcionario, long quarto);
	public List<Reserva> findByDataBetween(Calendar start, Calendar end);
}
