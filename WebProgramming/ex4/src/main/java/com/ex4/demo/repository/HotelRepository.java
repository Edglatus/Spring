package com.ex4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex4.demo.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {}
