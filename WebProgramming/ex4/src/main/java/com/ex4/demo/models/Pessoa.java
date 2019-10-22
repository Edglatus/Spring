package com.ex4.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Pessoa 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String rg;
	
	@OneToOne(cascade=CascadeType.ALL)
	//Change to JoinTable?
		@JoinColumn(name="fk_end") ..
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL)
	//Change to JoinTable?
	@JoinColumn(name="fk_tel") ..
	private List<Telefone> telefones;
	
	@ManyToMany(mappedBy="pessoas")
	private List<Hotel> hoteis;

	//Get-Set	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getRg() { return rg; }
	public void setRg(String rg) { this.rg = rg; }
	
	//get-set hoteis
		..
}
