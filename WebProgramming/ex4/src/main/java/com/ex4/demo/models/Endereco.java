package com.ex4.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="end_id")
	private long id;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private String uf;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getLogradouro() { return logradouro; }
	public void setLogradouro(String logr) { this.logradouro = logr; }
	
	public String getNumero() { return numero; }
	public void setNumero(String numero) { this.numero = numero; }
	
	public String getComplemento() { return complemento; }
	public void setComplemento(String comp) { this.complemento = comp; }
	
	public String getBairro() { return bairro; }
	public void setBairro(String bairro) { this.bairro = bairro; }
	
	public String getCidade() { return cidade; }
	public void setCidade(String cidade) { this.cidade = cidade; }
	
	public String getCep() { return cep; }
	public void setCep(String cep) { this.cep = cep; }
	
	public String getUf() { return uf; }
	public void setUf(String uf) { this.uf = uf; }	
}
