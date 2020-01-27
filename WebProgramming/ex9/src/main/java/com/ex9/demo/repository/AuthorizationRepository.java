package com.ex9.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex9.demo.model.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> { }
