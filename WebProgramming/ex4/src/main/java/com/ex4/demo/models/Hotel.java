package com.ex4.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Hotel 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_hotel")
	private long id;
	
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	//Change to JoinTable?
	@JoinColumn(name="fk_end") ..
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="")
	//Change to JoinTable?
	@JoinColumn(name="fk_tel") ..
	private List<Telefone> telefones;
	
	@ManyToMany @JoinTable(name="pessoa_hotel", 
							joinColumns=@JoinColumn(name="fk_hotel"), 
							inverseJoinColumns=@JoinColumn(name="fk_hotel"))
	private List<Pessoa> pessoas;
	
	@OneToMany(cascade=CascadeType.ALL) @JoinColumn(name="fk_hotel")
	private List<Quarto> quartos;
	
	//Get-Set	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public Endereco getEndereco() { return endereco; }
	public void setEndereco(Endereco endereco) { this.endereco = endereco; }
	
	public List<Telefone> getTelefones() { return telefones; }
	public void setTelefones(List<Telefone> tels) { this.telefones = tels; }
	
	//get-set Pessoas
	..
	
	public List<Quarto> getQuartos() { return quartos; }
	public void setQuartos(List<Quarto> quartos) { this.quartos = quartos; }
		
}
