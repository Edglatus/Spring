package com.ex3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco 
{
	//Attributes
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)	@Column(name="address_id")
	private long id;
	
	@Column(length=150, nullable=false)
	private String rua;
	
	@Column(length=50, nullable=false)
	private String bairro;
	
	@Column(length=80, nullable=false)
	private String cidade;
	
	@Column(length=90)
	private String cep;

	//Get-Set
	public long getId()	{ return this.id; }
	public void setId(long id) { this.id = id; }

	public String getRua() { return this.rua; }
	public void setRua(String rua) { this.rua = rua; }

	public String getBairro() { return this.bairro; }
	public void setBairro(String bairro) { this.bairro = bairro; }

	public String getCidade() { return this.cidade; }
	public void setCidade(String cidade) { this.cidade = cidade; }

	public String getCep() { return this.cep; }
	public void setCep(String cep) { this.cep = cep; }	
}
