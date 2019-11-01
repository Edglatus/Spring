package com.ex5.demo.dto;

public class TipoQuarto 
{
	//Attributes
	private long numCamas;
	private String tipo;
	
	//Get-Set
	public long getNumCamas() { return numCamas; }
	public void setNumCamas(long numCamas) { this.numCamas = numCamas; }
	
	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	
	//Constructors
	public TipoQuarto(long n, String t)
	{
		this.numCamas = n;
		this.tipo = t;
	}
}
