package com.ex9.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Usuario implements Serializable {
	//Serial
	private static final long serialVersionUID = 7690260505479020814L;

	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String pass;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Authorization> authorizations;
	//get-set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getUsername() { return username; }
	public void setUsername(String uN) { this.username = uN; }

	public String getPass() { return pass; }
	public void setPass(String pW) { this.pass = pW; }
	
	public List<Authorization> getAuthorizations() { return authorizations; }
	public void setAuthorizations(List<Authorization> a) { this.authorizations = a; }
	
}
