package com.ex9.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ex9.demo.model.Usuario;
import com.ex9.demo.repository.UsuarioRepository;

@Controller @RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UsuarioRepository repo;

	@GetMapping
	public ModelAndView getClientes()
	{
		ModelAndView mv = new ModelAndView("listUsers");

		mv.addObject("user", repo.findAll());

		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView getClientesForm()
	{
		ModelAndView mv = new ModelAndView("formUsers");

		mv.addObject("user", new Usuario());

		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView getAlterForm(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("formUsers");
		
		Optional<Usuario> entity = repo.findById(id);
		
		if(entity.isPresent())
		{
			mv.addObject("user", entity);
		}
		

		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String deleteClienteById(@PathVariable long id)
	{
		Optional<Usuario> entity = repo.findById(id);
		
		if(entity.isPresent())
		{
			repo.delete(entity.get());
		}

		return "redirect:/cliente";
	}	
	
	@PostMapping("/cadastrar")
	public String addCliente(@Valid Usuario entity, BindingResult bR)
	{
		if (bR.hasErrors())
		{
			return "formClientes";
		}
		
		repo.save(entity);
		return "redirect:/cliente";
	}
}
