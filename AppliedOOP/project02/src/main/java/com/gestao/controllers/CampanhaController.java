package com.gestao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.models.Campanha;
import com.gestao.repository.CampanhaRepository;

@Controller
public class CampanhaController 
{
	@Autowired
	CampanhaRepository campanhas;
	
	@GetMapping("campanhas")
	public ModelAndView getCampanha()
	{
		ModelAndView mv = new ModelAndView("ListaCampanhas.html");
		
		mv.addObject("campanhas", campanhas.findAll());
		mv.addObject(new Campanha());
		
		return mv;
	}
	
	@PostMapping("campanhas")
	public String addCampanha(Campanha f)
	{
		this.campanhas.save(f);
		return("redirect:/campanhas");
	}
	
	@GetMapping("campanhas/excluir/{id}")
	public String delCampanha(@PathVariable long id)
	{
		this.campanhas.deleteById(id);;
		return("redirect:/campanhas");
	}
	
	@GetMapping("campanhas/alterar/{id}")
	public ModelAndView altCampanha(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("ListaCampanhas.html");
		
		mv.addObject("campanhas", this.campanhas.findAll());
		mv.addObject("campanha", this.campanhas.findById(id));
		
		return mv;
	}
}
