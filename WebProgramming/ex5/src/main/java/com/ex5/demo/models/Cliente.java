package com.ex5.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa
{
	//Attributes
	private int quantidadeOcupacoes;
	
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;

	//Get-Set
	public int getQuantidadeOcupacoes() { return quantidadeOcupacoes; }
	public void setQuantidadeOcupacoes(int qtd) { this.quantidadeOcupacoes = qtd; }
	
	public List<Reserva> getReservas() { return reservas; }
	public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
	
	//Methods
}