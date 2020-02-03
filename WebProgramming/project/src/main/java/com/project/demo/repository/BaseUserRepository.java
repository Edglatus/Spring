package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.BaseUser;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {
	public BaseUser findByUsername(String uN);
}
