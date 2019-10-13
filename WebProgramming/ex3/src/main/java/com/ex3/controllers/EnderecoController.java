package com.ex3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ex3.models.Endereco;
import com.ex3.repository.EnderecoRepository;

public class EnderecoController 
{
	@Autowired
	private EnderecoRepository repo;
	
	//Create
	@RequestMapping(path="/endereco", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void addEnd(@RequestBody Endereco newE)
	{
		repo.save(newE);
	}
	
	//Read
	@RequestMapping(path="/endereco", method=RequestMethod.GET)
	public List<Endereco> getAllEnd()
	{
		return repo.findAll();
	}	
	@RequestMapping(path="/endereco/{id}", method=RequestMethod.GET)
	public Optional<Endereco> getEnd(@PathVariable long id)
	{
		return repo.findById(id);
	}
	
	//Update
	@RequestMapping(path="/endereco/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String updEnd(@RequestBody Endereco newE, @PathVariable long id)
	{
		newE.setId(id);
		repo.save(newE);
		return "redirect:/endereco";
	}
	
	//Delete
	@RequestMapping(path="/endereco/{id}", method=RequestMethod.DELETE)
	public String delEnd(@PathVariable long id)
	{
		repo.deleteById(id);
		return "redirect:/endereco";
	}
}
