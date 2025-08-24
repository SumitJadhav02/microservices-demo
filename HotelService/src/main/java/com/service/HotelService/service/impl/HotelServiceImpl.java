package com.service.HotelService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.exception.ResourceNotFoundException;
import com.service.HotelService.repository.HotelRepository;
import com.service.HotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String randomUUID = UUID.randomUUID().toString();
		hotel.setHotelId(randomUUID);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id "+hotelId));
	}

}
