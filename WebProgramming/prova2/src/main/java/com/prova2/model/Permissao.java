package com.prova2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Permissao {
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String nome;
	
	@ManyToMany(mappedBy="permissoes")
	private List<Usuario> usuarios;	
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public List<Usuario> getUsuarios() { return usuarios; }
	public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
	
}
