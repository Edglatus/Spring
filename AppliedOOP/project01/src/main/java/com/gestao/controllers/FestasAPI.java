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

import com.gestao.models.Festa;
import com.gestao.repository.FestaRepository;

@RestController
@RequestMapping("/api/festas")
public class FestasAPI {
	
	@Autowired
	private FestaRepository festas;
	
	//Create
	@PostMapping
	public ResponseEntity<?> saveFesta(Festa festa) {
	     return new ResponseEntity<Festa> (festas.save(festa), HttpStatus.OK);
	}
	
	//Read
	@GetMapping
	public List<Festa> getAllFestas(){ return this.festas.findAll(); }
	@GetMapping("/{id}")
	public Optional<Festa> getFesta(@PathVariable("id") Long id)
	{
		return this.festas.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> updateFesta(@PathVariable("id") Long id, Festa festa) 
	{
		Optional<Festa> c = festas.findById(id);
		
		if (!c.isPresent()) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(festa.getId() != id)
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		festas.save(festa);
		return new ResponseEntity<Festa>(festas.save(festa), HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFesta(@PathVariable("id") Long id) 
	{
		Optional<Festa> c = festas.findById(id);
		
		if (c == null) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		festas.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
