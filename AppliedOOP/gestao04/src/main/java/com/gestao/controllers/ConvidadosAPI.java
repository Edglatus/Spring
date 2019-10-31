package com.gestao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.models.Convidado;
import com.gestao.repository.ConvidadoRepository;

@RestController
@RequestMapping("/api/convidados")
public class ConvidadosAPI {
	
	@Autowired
	private ConvidadoRepository convidados;
	
	//Create
	@PostMapping
	public ResponseEntity<?> saveConvidado(Convidado convidado) {
	     return new ResponseEntity<Convidado> (convidados.save(convidado), HttpStatus.OK);
	}
	
	//Read
	@GetMapping
	public List<Convidado> getAllConvidados(){ return this.convidados.findAll(); }
	@GetMapping("/{id}")
	public Optional<Convidado> getConvidado(@PathVariable("id") Long id)
	{
		return this.convidados.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> updateConvidado(@PathVariable("id") Long id, Convidado convidado) 
	{
		Optional<Convidado> c = convidados.findById(id);
		
		if (!c.isPresent()) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(convidado.getId() != id)
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		convidados.save(convidado);
		return new ResponseEntity<Convidado>(convidados.save(convidado), HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteConvidado(@PathVariable("id") Long id) 
	{
		Optional<Convidado> c = convidados.findById(id);
		
		if (c == null) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		convidados.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
