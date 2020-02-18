package com.prova2.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prova2.model.Funcionario;
import com.prova2.repository.FuncionarioRepository;

@Controller("")
public class FuncionariosController {
	@Autowired
	private FuncionarioRepository repo;	
	
	//Create
	@GetMapping("/create")
	public String formFuncionarios(Model model) {
		model.addAttribute("funcionario", new Funcionario());
			
		return("form");
	}	
	@PostMapping("/create")
	public String add(@Valid @ModelAttribute Funcionario entity, BindingResult bR, Model model) {
		if(bR.hasErrors()) {
			return ("form");
		}
		
		repo.save(entity);	
		
		return("redirect:/");
	}
	
	//Read
	@GetMapping()
	public String toFuncionarios(Model model) {
		model.addAttribute("funcionarios", repo.findAll());
		
		return("list");
	}
	@GetMapping("/{id}")
	public String oneFuncionario(@PathVariable int id, Model model) {
		ArrayList<Funcionario> list = new ArrayList<Funcionario>();
		Optional<Funcionario> found = repo.findById(id);
		
		if(found.isPresent()) {
			list.add(found.get());
		}
		
		model.addAttribute("funcionarios", repo.findAll());
		
		return("list");
	}
	@PostMapping("/login")
	public String login() {
		return("redirect:../");
	}
	
	//Update
	@GetMapping("/update/{id}")
	public String formUpdate(@PathVariable int id, Model model) {
		Optional<Funcionario> found = repo.findById(id);
		
		if(!found.isPresent()) {
			return ("redirect:../");
		}
		
		model.addAttribute("funcionario", found.get());
			
		return("form");
	}
	
	//Delete
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		Optional<Funcionario> found = repo.findById(id);
		
		if(found.isPresent()) {
			repo.delete(found.get());
		}
		
		return("redirect:../");
	}
}
