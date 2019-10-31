package com.ex5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex5.demo.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {}
