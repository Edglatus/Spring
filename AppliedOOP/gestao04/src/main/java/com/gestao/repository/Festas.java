package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.models.Festa;

public interface Festas extends JpaRepository<Festa, Long>
{
	
}
