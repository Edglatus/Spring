package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findByNameLike(String n);
}
