package com.ex5.demo.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Reserva.findByIDs", 
	query="SELECT r FROM Reserva r JOIN r.cliente c JOIN r.funcionario f JOIN r.quartos q WHERE c.id = ?1 AND f.id = ?2 AND q.id = ?3")
public class Reserva 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)@Column(name="id_reserva")
	private long id;
	
	private Calendar data;
	
	@ManyToOne @JoinColumn(name="cli_id")
	private Cliente cliente;
	
	@ManyToOne @JoinColumn(name="func_id")
	private Funcionario funcionario;
	
	@ManyToMany @JoinTable(name="reserva_quartos", 
							joinColumns=@JoinColumn(name="fk_reserva"), 
							inverseJoinColumns=@JoinColumn(name="fk_quarto"))
	private List<Quarto> quartos;
	
	//Get-Set	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public Calendar getData() { return data; }
	public void setData(Calendar data) { this.data = data; }
	
	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	
	public Funcionario getFuncionario() { return funcionario; }
	public void setFuncionario(Funcionario func) { this.funcionario = func; }
	
	public List<Quarto> getQuartos() { return quartos; }
	public void setQuartos(List<Quarto> quartos) { this.quartos = quartos; }
}
