package com.ex3.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Funcionario 
{
	//Attributes
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)	@Column(name="func_id")
	private long id;
	
	@Column(length=100, nullable=false)
	private String name;
	
	@Column(length=150)
	private String email;
	
	@Column(scale=2)
	private float salary;
	
	@Temporal(TemporalType.DATE) @DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar birthdate;

	//Get-Set
	public long getId()	{ return this.id; }
	public void setId(long id) { this.id = id; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }

	public float getSalary() { return this.salary; }
	public void setSalary(float salary) { this.salary = salary; }

	public Calendar getBirthdate() { return this.birthdate; }
	public void setBirthdate(Calendar birthdate) { this.birthdate = birthdate; }	
}
