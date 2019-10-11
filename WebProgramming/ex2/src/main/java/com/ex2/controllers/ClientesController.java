package com.ex2.controllers;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ex2.models.Pessoa;

@RestController
public class ClientesController 
{
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	@RequestMapping(path="/clientes", method=RequestMethod.GET)
	public ArrayList<Pessoa> getAllClientes()
	{
		return this.pessoas;
	}
	
	@RequestMapping(path="/clientes/{nome}", method=RequestMethod.GET)
	public Pessoa getPessoa(@PathVariable("nome") String nome)
	{		
		for(Pessoa i : pessoas)
		{
			if(i.getNome().equals(nome))
				return i;
		}
		
		return null;
	}
	
	@RequestMapping(path="/clientes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	public void addPessoa(@RequestBody Pessoa newPessoa)
	{
		this.pessoas.add(newPessoa);
	}
	
	@RequestMapping(path = "/clientes/{nome}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.PUT)
	public void altPessoa(@PathVariable("nome") String nome, @RequestBody Pessoa newPessoa)
	{
		this.pessoas.forEach((p)->{
					if(p.getNome().equalsIgnoreCase(nome))
						this.pessoas.set(pessoas.indexOf(p), newPessoa);
				});
	}
	
	@RequestMapping(path = "/clientes/{nome}", method=RequestMethod.DELETE)
	public void deletePessoa(@PathVariable("nome") String nome)
	{		
		this.pessoas.removeIf(p -> (p.getNome().equalsIgnoreCase(nome)));
	}
}
