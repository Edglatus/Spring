package com.prova2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Entity
public class Funcionario {
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cargo;
	
	@Digits(integer=10, fraction=2)
	private double salario;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String telefone;

	//Get-Set
	public int getCodigo() { return codigo; }
	public void setCodigo(int codigo) { this.codigo = codigo; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getCargo() { return cargo; }
	public void setCargo(String cargo) { this.cargo = cargo; }

	public double getSalario() { return salario; }
	public void setSalario(double salario) { this.salario = salario; }

	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }

	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }

}
