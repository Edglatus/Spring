package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.models.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{}