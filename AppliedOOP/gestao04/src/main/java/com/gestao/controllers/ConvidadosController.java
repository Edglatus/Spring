package com.gestao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.models.Convidado;
import com.gestao.repository.Convidados;

@Controller
public class ConvidadosController 
{
	@Autowired
	Convidados convidados;
	
	@GetMapping("convidados")
	public ModelAndView getConvidados()
	{
		ModelAndView mv = new ModelAndView("ListaConvidados.html");
		
		mv.addObject("convidados", convidados.findAll());
		mv.addObject(new Convidado());
		
		return mv;
	}
	
	@PostMapping("convidados")
	public String addConvidado(Convidado c)
	{
		this.convidados.save(c);
		return("redirect:/convidados");
	}
	
	@GetMapping("convidados/excluir/{id}")
	public String delConvidado(@PathVariable long id)
	{
		this.convidados.deleteById(id);;
		return("redirect:/convidados");
	}
	
	@GetMapping("convidados/alterar/{id}")
	public ModelAndView altConvidados(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("ListaConvidados.html");
		
		mv.addObject("convidados", this.convidados.findAll());
		mv.addObject("convidado", this.convidados.findById(id));
		
		return mv;
	}
}
