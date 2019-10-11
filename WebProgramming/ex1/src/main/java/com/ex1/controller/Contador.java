package com.ex1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contador")
public class Contador 
{
	private int counter = 0;
	
	@GetMapping
	public int getCounter()
	{			
		return counter;
	}
	
	@PostMapping
	public String incrementCounter()
	{
		counter++;
		return "Contador incrementado.";		
	}
	
	@PutMapping
	public String resetCounter()
	{
		counter = 0;
		return "Contador zerado.";
	}
	
	@DeleteMapping
	public String decrementCounter()
	{
		counter--;
		return "Contador decrementado.";
	}
}
