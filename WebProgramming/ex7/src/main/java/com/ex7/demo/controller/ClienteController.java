package com.ex7.demo.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ex7.demo.model.Cliente;
import com.ex7.demo.repository.ClienteRepository;

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

		mv.addObject("cliente", new Cliente());

		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView getAlterForm(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("formClientes");
		
		Optional<Cliente> entity = repo.findById(id);
		
		if(entity.isPresent())
		{
			mv.addObject("cliente", entity);
		}
		

		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String deleteClienteById(@PathVariable long id)
	{
		Optional<Cliente> entity = repo.findById(id);
		
		if(entity.isPresent())
		{
			repo.delete(entity.get());
		}

		return "redirect:/cliente";
	}	
	
	@PostMapping("/cadastrar")
	public String addCliente(@RequestParam("file") MultipartFile file, @RequestParam("image") MultipartFile image, Cliente entity)
	{
		if (image.isEmpty() || file.isEmpty())
		{
			return "formClientes";
		}
		
		try 
		{
			String imageName = Calendar.getInstance().getTimeInMillis() + image.getOriginalFilename();
			Path imageDestination = Paths.get(context.getRealPath("resources/uploads/images/") + imageName);
			image.transferTo(imageDestination);
			
			entity.setFoto(context.getContextPath() + "/images/" + imageName);
			
			String fileName = Calendar.getInstance().getTimeInMillis() + file.getOriginalFilename();
			Path fileDestination = Paths.get(context.getRealPath("resources/uploads/documents/") + fileName);
			file.transferTo(fileDestination);
			
			entity.setCurriculum(context.getContextPath() + "/files/" + fileName);
		}
		catch (Exception er)
		{
			er.printStackTrace();
		}
		
		repo.save(entity);
		return "redirect:/cliente";
	}
}
