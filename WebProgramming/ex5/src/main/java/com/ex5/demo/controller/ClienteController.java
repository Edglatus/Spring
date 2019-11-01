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

import com.ex5.demo.models.Cliente;
import com.ex5.demo.repository.ClienteRepository;

@RestController @RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	private ClienteRepository repo;
	
	//Create
	@PostMapping
	public void addCliente(@RequestBody Cliente entity)
	{
		repo.save(entity);
	}
	
	//Read
	@GetMapping
	public List<Cliente> getClientes()
	{
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Cliente> getOneCliente(@RequestAttribute("id") long id)
	{
		return repo.findById(id);
	}
	
	//Update
	@PutMapping("/{id}")
	public void updateCliente(@RequestAttribute("id") long id, @RequestBody Cliente entity)
	{
		if(repo.findById(id).isPresent() && entity.getId() == id)
			repo.save(entity);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteCliente(@RequestAttribute("id") long id)
	{
		Optional<Cliente> found = repo.findById(id);
		if(found.isPresent())
			repo.deleteById(id);
	}
	
	//Methods
	@GetMapping("/{id}/reservas")
	public long getNumReservas(@RequestAttribute("id") long id)
	{
		return repo.getReservas(id);
	}
}
