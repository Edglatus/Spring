package com.project.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Authorization {
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;	
	
	@ManyToMany(mappedBy="authorizations") @Valid @NotEmpty
	private List<BaseUser> users;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String n) { this.name = n; }
	
	public List<BaseUser> getUsers() { return users; }
	public void setUsers(List<BaseUser> u) { this.users = u; }
}
