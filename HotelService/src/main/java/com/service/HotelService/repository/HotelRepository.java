package com.service.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.HotelService.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
