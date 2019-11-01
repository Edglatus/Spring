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

import com.gestao.models.Campanha;
import com.gestao.repository.CampanhaRepository;

@RestController
@RequestMapping("/api/campanhas")
public class CampanhaAPI {
	
	@Autowired
	private CampanhaRepository campanhas;
	
	//Create
	@PostMapping
	public ResponseEntity<?> saveFesta(Campanha festa) {
	     return new ResponseEntity<Campanha> (campanhas.save(festa), HttpStatus.OK);
	}
	
	//Read
	@GetMapping
	public List<Campanha> getAllCampanhas(){ return this.campanhas.findAll(); }
	@GetMapping("/{id}")
	public Optional<Campanha> getFesta(@PathVariable("id") Long id)
	{
		return this.campanhas.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> updateFesta(@PathVariable("id") Long id, Campanha festa) 
	{
		Optional<Campanha> c = campanhas.findById(id);
		
		if (!c.isPresent()) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(festa.getId() != id)
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		campanhas.save(festa);
		return new ResponseEntity<Campanha>(campanhas.save(festa), HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFesta(@PathVariable("id") Long id) 
	{
		Optional<Campanha> c = campanhas.findById(id);
		
		if (c == null) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		campanhas.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
