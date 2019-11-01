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

import com.gestao.models.Jogador;
import com.gestao.repository.JogadorRepository;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorAPI {
	
	@Autowired
	private JogadorRepository jogadores;
	
	//Create
	@PostMapping
	public ResponseEntity<?> saveConvidado(Jogador convidado) {
	     return new ResponseEntity<Jogador> (jogadores.save(convidado), HttpStatus.OK);
	}
	
	//Read
	@GetMapping
	public List<Jogador> getAllJogadores(){ return this.jogadores.findAll(); }
	@GetMapping("/{id}")
	public Optional<Jogador> getConvidado(@PathVariable("id") Long id)
	{
		return this.jogadores.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> updateConvidado(@PathVariable("id") Long id, Jogador convidado) 
	{
		Optional<Jogador> c = jogadores.findById(id);
		
		if (!c.isPresent()) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(convidado.getId() != id)
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		jogadores.save(convidado);
		return new ResponseEntity<Jogador>(jogadores.save(convidado), HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteConvidado(@PathVariable("id") Long id) 
	{
		Optional<Jogador> c = jogadores.findById(id);
		
		if (c == null) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		jogadores.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
