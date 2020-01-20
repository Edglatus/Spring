package com.ex8.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Entity
public class Telefone 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@DecimalMax(value="9", message="Número inválido.")
	@DecimalMin(value="9", message="Número inválido.")
	private String numero;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getNumero() { return numero; }
	public void setNumero(String numero) { this.numero = numero; }
}
