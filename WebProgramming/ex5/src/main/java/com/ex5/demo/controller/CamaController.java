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

import com.ex5.demo.models.Cama;
import com.ex5.demo.repository.CamaRepository;

@RestController @RequestMapping("/cama")
public class CamaController 
{
	@Autowired
	private CamaRepository repo;
	
	//Create
	@PostMapping
	public void addCama(@RequestBody Cama entity)
	{
		repo.save(entity);
	}
	
	//Read
	@GetMapping
	public List<Cama> getCamas()
	{
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Cama> getOneCama(@RequestAttribute("id") long id)
	{
		return repo.findById(id);
	}
	
	//Update
	@PutMapping("/{id}")
	public void updateCama(@RequestAttribute("id") long id, @RequestBody Cama entity)
	{
		if(repo.findById(id).isPresent() && entity.getId() == id)
			repo.save(entity);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteCama(@RequestAttribute("id") long id)
	{
		Optional<Cama> found = repo.findById(id);
		if(found.isPresent())
			repo.deleteById(id);
	}
}
