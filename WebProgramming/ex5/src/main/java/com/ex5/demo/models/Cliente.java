package com.ex5.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity 
@NamedQuery(name="Cliente.getReservas", query="SELECT COUNT(r.id) FROM Cliente c JOIN c.Reservas r WHERE c.id = ?1")
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