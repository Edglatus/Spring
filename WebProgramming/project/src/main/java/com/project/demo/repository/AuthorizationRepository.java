package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {}
