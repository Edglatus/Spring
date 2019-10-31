package com.ex5.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Funcionario extends Pessoa
{
	//Attributes
	private String setor;
	
	@OneToMany(mappedBy="funcionario")
	private List<Reserva> reservas;

	//Get-Set
	public String getSetor() { return setor; }
	public void setSetor(String setor) { this.setor = setor; }
	
	public List<Reserva> getReservas() { return reservas; }
	public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
}