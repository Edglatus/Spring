package com.ex5.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Quarto 
{
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_quarto")
	private long id;
	
	private String tipo;
	private boolean isOcupado;
	private int numeroDoQuarto;
	
	@OneToMany(cascade=CascadeType.PERSIST) @JoinColumn(name="fk_quarto")
	private List<Cama> camas;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	
	public void setOcupado(boolean isOcupado) { this.isOcupado = isOcupado; }
	
	public int getNumeroDoQuarto() { return numeroDoQuarto; }
	public void setNumeroDoQuarto(int num) { this.numeroDoQuarto = num; }
	
	public List<Cama> getCamas() { return camas; }
	public void setCamas(List<Cama> camas) { this.camas = camas; }
	
	//Methods
	public boolean verificarDisponibilidade() { return isOcupado; }
}
