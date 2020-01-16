package com.ex6.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco 
{
	//Attributes	
	private String rua;	
	private int numero;
	
	//Get-Set
	public String getRua() { return rua; }
	public void setRua(String rua) { this.rua = rua; }

	public int getNumero() { return numero; }
	public void setNumero(int numero) { this.numero = numero; }
}
