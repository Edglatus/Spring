package com.ex9.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Authorization implements Serializable {
	//Serial
	private static final long serialVersionUID = -6346599501215016101L;

	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@ManyToMany(mappedBy="authorizations")
	private List<Usuario> usuarios;
	
	//get-set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String n) { this.name = n; }
	
	public List<Usuario> getUsuarios() { return usuarios; }
	public void setUsuarios(List<Usuario> u) { this.usuarios = u; }
}
