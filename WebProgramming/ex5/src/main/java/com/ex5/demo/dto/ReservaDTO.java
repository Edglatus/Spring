package com.ex5.demo.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.ex5.demo.models.Reserva;

public class ReservaDTO 
{
	//Attributes
	private long id;
	private Calendar data;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public Calendar getData() { return data; }
	public void setData(Calendar data) { this.data = data; }
	
	//Constructors
	public ReservaDTO(){}
	public ReservaDTO(Reserva r)
	{
		this.id = r.getId();
		this.data = r.getData();
	}
	
	//Methods
	public static ReservaDTO toDTO(Optional<Reserva> r)
	{
		return new ReservaDTO(r.get());
	}
	public static ReservaDTO toDTO(Reserva r)
	{
		return new ReservaDTO(r);
	}
	
	public static List<ReservaDTO> listToDTO(List<Reserva> list)
	{
		List<ReservaDTO> listDTO = new ArrayList<ReservaDTO>();
		
		list.forEach((r) -> listDTO.add(ReservaDTO.toDTO(r)));
		
		return listDTO;
	}
}
