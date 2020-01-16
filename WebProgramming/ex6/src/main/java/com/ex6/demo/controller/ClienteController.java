package com.ex6.demo.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ex6.demo.model.Cliente;
import com.ex6.demo.repository.ClienteRepository;

@Controller @RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private ServletContext context;

	@GetMapping
	public ModelAndView getClientes()
	{
		ModelAndView mv = new ModelAndView("listClientes");

		mv.addObject("clientes", repo.findAll());

		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView getClientesForm()
	{
		ModelAndView mv = new ModelAndView("formClientes");

		mv.addObject(new Cliente());

		return mv;
	}

	@PostMapping("/cadastrar")
	public String addCliente(@RequestParam("file") MultipartFile file, Cliente entity)
	{
		if (file.isEmpty())
		{
			return "formClientes";
		}
		
		try 
		{
			String name = Calendar.getInstance().getTimeInMillis() + file.getOriginalFilename();
			Path destination = Paths.get("C:\\Users\\Edgla\\Pictures\\" + name);
			file.transferTo(destination);
			
			entity.setFoto(context.getContextPath() + "/files/" + name);
		}
		catch (Exception er)
		{
			er.printStackTrace();
		}
		
		repo.save(entity);
		return "redirect:/cliente";
	}
}
