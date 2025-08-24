package com.service.HotelService.service;

import java.util.List;

import com.service.HotelService.entity.Hotel;

public interface HotelService {

	//create
	
	  Hotel saveHotel(Hotel hotel);
	  
	//get all
	
	  List<Hotel> getAll();
	  
	//getOne
	  
	  Hotel get(String hotelId);
	
	
	
}
