package com.prova2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Permissao> permissoes;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public List<Permissao> getPermissoes() { return permissoes; }
	public void setPermissoes(List<Permissao> permissoes) { this.permissoes = permissoes; }
}
