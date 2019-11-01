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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex5.demo.models.Funcionario;
import com.ex5.demo.repository.FuncionarioRepository;

@RestController @RequestMapping("/funcionario")
public class FuncionarioController 
{
	@Autowired
	private FuncionarioRepository repo;
	
	//Create
	@PostMapping
	public void addFuncionario(@RequestBody Funcionario entity)
	{
		repo.save(entity);
	}
	
	//Read
	@GetMapping
	public List<Funcionario> getFuncionarios()
	{
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Funcionario> getOneFuncionario(@RequestAttribute("id") long id)
	{
		return repo.findById(id);
	}
	
	//Update
	@PutMapping("/{id}")
	public void updateFuncionario(@RequestAttribute("id") long id, @RequestBody Funcionario entity)
	{
		if(repo.findById(id).isPresent() && entity.getId() == id)
			repo.save(entity);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void deleteFuncionario(@RequestAttribute("id") long id)
	{
		Optional<Funcionario> found = repo.findById(id);
		if(found.isPresent())
			repo.deleteById(id);
	}
	
	//Methods
	@GetMapping("/setor")
	public List<Funcionario> getFromSetor(@RequestParam("setor") String setor)
	{
		return repo.findBySetor(setor);
	}
}
