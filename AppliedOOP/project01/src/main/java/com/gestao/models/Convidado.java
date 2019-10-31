package com.gestao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Convidado 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int qtd;
	private String nome;
	
	@ManyToOne @JoinColumn(name = "fk_festa")
	private Festa festa;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public int getQtd() { return qtd; }
	public void setQtd(int qtd) { this.qtd = qtd; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public Festa getFesta() { return festa; }
	public void setFesta(Festa festa) { this.festa = festa; }
}