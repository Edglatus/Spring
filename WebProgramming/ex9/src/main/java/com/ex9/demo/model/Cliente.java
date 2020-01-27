package com.ex9.demo.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente 
{
	//Attributes	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd") @Past(message="Data inválida.")
	private Calendar dtNasc;
	
	@NotBlank(message="O nome não deve estar em branco.")
	private String nome;
	
	private String foto;
	private String curriculum;
	
	@Embedded 
	@AttributeOverrides({
	  @AttributeOverride(name="rua", column=@Column(name="endereco_rua")),
	  @AttributeOverride(name="numero", column=@Column(name="endereco_numero"))
	}) @NotNull @Valid 
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true) @JoinColumn(name="fk_cliente") @NotEmpty @Valid
	private List<Telefone> telefones;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public Calendar getDtNasc() { return dtNasc; }
	public void setDtNasc(Calendar dtNasc) { this.dtNasc = dtNasc; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getFoto() { return foto; }
	public void setFoto(String foto) { this.foto = foto; }
	
	public Endereco getEndereco() { return endereco; }
	public void setEndereco(Endereco endereco) { this.endereco = endereco; }
	
	public List<Telefone> getTelefones() { return telefones; }
	public void setTelefones(List<Telefone> telefones) { this.telefones = telefones; }
	
	public String getCurriculum() { return curriculum; }
	public void setCurriculum(String curriculum) { this.curriculum = curriculum; }	
}
