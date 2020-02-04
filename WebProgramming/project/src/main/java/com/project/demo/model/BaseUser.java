package com.project.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class BaseUser {
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String username;	
	@NotBlank
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER) @NotEmpty @Valid
	private List<Authorization> authorizations;

	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getUsername() { return username; }
	public void setUsername(String u) { this.username = u; }

	public String getPassword() { return password; }
	public void setPassword(String p) { this.password = p; }

	public List<Authorization> getAuthorizations() { return authorizations; }
	public void setAuthorizations(List<Authorization> a) { this.authorizations = a; }
	
}
