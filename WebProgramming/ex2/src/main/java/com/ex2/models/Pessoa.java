package com.ex2.models;

public class Pessoa 
{
	//Attributes
	private String nome, rg, cpf, sexo, telefone, celular, email;

	//Get-Set
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getRg() { return this.rg; }
	public void setRg(String rg) { this.rg = rg; }

	public String getCpf() { return this.cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }

	public String getSexo() { return this.sexo; }
	public void setSexo(String sexo) { this.sexo = sexo; }

	public String getTelefone() { return this.telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }

	public String getCelular() { return this.celular; }
	public void setCelular(String celular) { this.celular = celular; }

	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
}
