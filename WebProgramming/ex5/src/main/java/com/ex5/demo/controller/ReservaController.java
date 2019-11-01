package com.ex5.demo.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex5.demo.dto.ReservaDTO;
import com.ex5.demo.models.Reserva;
import com.ex5.demo.repository.ReservaRepository;

@RestController @RequestMapping("/reserva")
public class ReservaController 
{
	@Autowired
	private ReservaRepository repo;
	
	//Create
	@PostMapping
	public void addReserva(@RequestBody Reserva entity)
	{
		repo.save(entity);
	}
	
	//Read
	@GetMapping
	public List<ReservaDTO> getReservas()
	{
		return ReservaDTO.listToDTO(repo.findAll());
	}
	@GetMapping("/{id}")
	public ReservaDTO getOneReserva(@RequestAttribute("id") long id)
	{
		return ReservaDTO.toDTO(repo.findById(id));
	}
	
	//Update
	@PutMapping("/{id}")
	public void updateReserva(@RequestAttribute("id") long id, @RequestBody Reserva entity)
	{
		if(repo.findById(id).isPresent() && entity.getId() == id)
			repo.save(entity);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteReserva(@RequestAttribute("id") long id)
	{
		Optional<Reserva> found = repo.findById(id);
		if(found.isPresent())
			repo.deleteById(id);
	}
	
	//Methods
	@GetMapping("/{c}/{f}/{q}")
	public List<ReservaDTO> getByIDs(@RequestAttribute("c") long cli, @RequestAttribute("f") long func, @RequestAttribute("q") long qua)
	{
		return ReservaDTO.listToDTO(repo.findByIDs(cli, func, qua));
	}
	
	@GetMapping("/date")
	public List<ReservaDTO> getByDates(@RequestParam Calendar start, @RequestParam Calendar end)
	{
		return ReservaDTO.listToDTO(repo.findByDataBetween(start, end));
	}
}
