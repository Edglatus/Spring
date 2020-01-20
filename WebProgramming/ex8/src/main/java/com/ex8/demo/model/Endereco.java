package com.ex8.demo.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Embeddable
public class Endereco 
{
	//Attributes
	@NotBlank(message="O nome da rua não deve estar em branco")
	private String rua;
	
	@Positive(message="O número da casa deve ser positivo.")
	private int numero;
	
	//Get-Set
	public String getRua() { return rua; }
	public void setRua(String rua) { this.rua = rua; }

	public int getNumero() { return numero; }
	public void setNumero(int numero) { this.numero = numero; }
}
