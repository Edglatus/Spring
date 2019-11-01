package com.ex5.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ex5.demo.dto.TipoQuarto;
import com.ex5.demo.models.Cama;
import com.ex5.demo.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	@Query("SELECT q.camas FROM Hotel h JOIN h.quartos WHERE h.id = ?1")
	public List<Cama> findCamas(long id);
	public List<TipoQuarto> findTipoQuarto(long id);
}
