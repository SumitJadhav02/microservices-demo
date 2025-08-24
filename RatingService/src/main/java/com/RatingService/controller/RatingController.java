package com.RatingService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RatingService.entity.Rating;
import com.RatingService.service.impl.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	private RatingServiceImpl ratingServiceImpl;

	public RatingController(RatingServiceImpl ratingServiceImpl) {
		super();
		this.ratingServiceImpl = ratingServiceImpl;
	}
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		Rating newRating = ratingServiceImpl.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getOneById(@PathVariable("ratingId") String ratingId)
	{
		Rating rating = ratingServiceImpl.get(ratingId);
		return ResponseEntity.ok(rating);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		List<Rating> allRatings = ratingServiceImpl.getAll();
		return ResponseEntity.ok(allRatings);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("userId") String userId)
	{
		List<Rating> ratingsByUserId = ratingServiceImpl.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingsByUserId);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("hotelId") String hotelId)
	{
		List<Rating> ratingsByHotelId = ratingServiceImpl.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingsByHotelId);
	}
	
	
}
