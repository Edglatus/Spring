package com.gestao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.models.Festa;
import com.gestao.repository.Festas;

@Controller
public class FestasController 
{
	@Autowired
	Festas festa;
	
	@GetMapping("festas")
	public ModelAndView getFestas()
	{
		ModelAndView mv = new ModelAndView("ListaFestas.html");
		
		mv.addObject("festas", festa.findAll());
		mv.addObject(new Festa());
		
		return mv;
	}
	
	@PostMapping("festas")
	public String addFesta(Festa f)
	{
		this.festa.save(f);
		return("redirect:/festas");
	}
	
	@GetMapping("festas/excluir/{id}")
	public String delFesta(@PathVariable long id)
	{
		this.festa.deleteById(id);;
		return("redirect:/festas");
	}
	
	@GetMapping("festas/alterar/{id}")
	public ModelAndView altFesta(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("ListaFestas.html");
		
		mv.addObject("festas", this.festa.findAll());
		mv.addObject("festa", this.festa.findById(id));
		
		return mv;
	}
}
