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
import org.springframework.web.bind.annotation.RestController;

import com.ex3.models.Funcionario;
import com.ex3.repository.FuncionarioRepository;

@RestController
public class FuncionarioController 
{
	@Autowired
	private FuncionarioRepository repo;
	
	//Create
	@RequestMapping(path="/funcionario", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void addFunc(@RequestBody Funcionario newF)
	{
		repo.save(newF);
	}
	
	//Read
	@RequestMapping(path="/funcionario", method=RequestMethod.GET)
	public List<Funcionario> getAllFunc()
	{
		return repo.findAll();
	}	
	@RequestMapping(path="/funcionario/{id}", method=RequestMethod.GET)
	public Optional<Funcionario> getFunc(@PathVariable long id)
	{
		return repo.findById(id);
	}
	
	//Update
	@RequestMapping(path="/funcionario/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void updFunc(@RequestBody Funcionario newF, @PathVariable long id)
	{
		newF.setId(id);
		repo.save(newF);
	}
	
	//Delete
	@RequestMapping(path="/funcionario/{id}", method=RequestMethod.DELETE)
	public void delFunc(@PathVariable long id)
	{
		repo.deleteById(id);
	}
}
