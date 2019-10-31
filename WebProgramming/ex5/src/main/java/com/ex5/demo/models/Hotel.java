package com.ex5.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Hotel 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_hotel")
	private long id;
	
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_end") 
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="hotel_telefone",
				joinColumns=@JoinColumn(name="id_hotel"),
				inverseJoinColumns=@JoinColumn(name="id_telefone"))
	private List<Telefone> telefones;
	
	@ManyToMany @JoinTable(name="pessoa_hotel", 
							joinColumns=@JoinColumn(name="fk_hotel"), 
							inverseJoinColumns=@JoinColumn(name="fk_pessoa"))
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
		
	public List<Pessoa> getPessoas() { return pessoas; }
	public void setPessoas(List<Pessoa> pessoas) { this.pessoas = pessoas; }
	
	public List<Quarto> getQuartos() { return quartos; }
	public void setQuartos(List<Quarto> quartos) { this.quartos = quartos; }
		
}
