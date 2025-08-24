package com.RatingService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.RatingService.entity.Rating;
import com.RatingService.exception.ResourceNotFoundException;
import com.RatingService.repository.RatingRepository;
import com.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	private RatingRepository ratingRepository;
	public RatingServiceImpl(RatingRepository ratingRepository) {
		super();
		this.ratingRepository = ratingRepository;
	}

	@Override
	public Rating saveRating(Rating rating) {
		String randomUUID =  UUID.randomUUID().toString();
		rating.setRatingId(randomUUID);
		return ratingRepository.save(rating);
	}

	@Override
	public Rating get(String ratingId) {
		
		return ratingRepository.findById(ratingId)
				.orElseThrow(()->new ResourceNotFoundException("Rating not found with thsi id"+ratingId));
	}

	@Override
	public List<Rating> getAll(){
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
