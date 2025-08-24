package com.RatingService.service;

import java.util.List;

import com.RatingService.entity.Rating;

public interface RatingService {

	//create 
	Rating saveRating(Rating rating);
	
	//getOne
	Rating get(String ratingId);
	
	//getAll
	List<Rating> getAll();
	
	//find by userID
	List<Rating> getRatingByUserId(String userId);
	
	//find by hotelID
	List<Rating> getRatingByHotelId(String hotelId);
}
