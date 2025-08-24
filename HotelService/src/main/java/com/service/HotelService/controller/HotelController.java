package com.service.HotelService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.service.impl.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private HotelServiceImpl hotelServiceImpl;
	public HotelController(HotelServiceImpl hotelServiceImpl) {
		super();
		this.hotelServiceImpl = hotelServiceImpl;
	}


	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		Hotel newhotel = hotelServiceImpl.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(newhotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels()
	{
		List<Hotel> allhotels = hotelServiceImpl.getAll();
		return ResponseEntity.ok(allhotels);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable("hotelId") String hotelId)
	{
		Hotel singlehotel = hotelServiceImpl.get(hotelId);
		return ResponseEntity.ok(singlehotel);
	}
	
}
