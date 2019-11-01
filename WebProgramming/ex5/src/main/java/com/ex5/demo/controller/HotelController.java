package com.ex5.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ex5.demo.dto.TipoQuarto;
import com.ex5.demo.models.Cama;
import com.ex5.demo.models.Hotel;
import com.ex5.demo.repository.HotelRepository;

@RestController @RequestMapping("/hotel")
public class HotelController 
{
	@Autowired
	private HotelRepository repo;
	
	//Create
	@PostMapping
	public void addHotel(@RequestBody Hotel entity)
	{
		repo.save(entity);
	}
	
	//Read
	@GetMapping
	public List<Hotel> getHotels()
	{
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Hotel> getOneHotel(@RequestAttribute("id") long id)
	{
		return repo.findById(id);
	}
	
	//Update
	@PutMapping("/{id}")
	public void updateHotel(@RequestAttribute("id") long id, @RequestBody Hotel entity)
	{
		if(repo.findById(id).isPresent() && entity.getId() == id)
			repo.save(entity);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteHotel(@RequestAttribute("id") long id)
	{
		Optional<Hotel> found = repo.findById(id);
		if(found.isPresent())
			repo.deleteById(id);
	}
	
	//Methods
	@GetMapping("/{id}/camas")
	public List<Cama> getCamas(@RequestAttribute("id") long id)
	{
		return repo.findCamas(id);
	}
	
	@GetMapping("/{id}/quartos")
	public List<TipoQuarto> getTipoQuartos(@RequestAttribute("id") long id)
	{
		return repo.findTipoQuarto(id);
	}
}
