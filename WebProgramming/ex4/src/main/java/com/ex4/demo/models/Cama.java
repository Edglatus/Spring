package com.ex4.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cama 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_cama")
	private long id;
	
	private String tipo;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
}
