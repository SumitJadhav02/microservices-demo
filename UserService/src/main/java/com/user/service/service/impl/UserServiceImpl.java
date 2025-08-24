package com.user.service.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.entity.Hotel;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.external.services.HotelServiceClient;
import com.user.service.external.services.RatingServiceClient;
import com.user.service.repository.UserRepository;
import com.user.service.service.UserService;

import lombok.Builder;

@Service
public class UserServiceImpl implements UserService {
	
	private HotelServiceClient hotelServiceClient;
	private RatingServiceClient ratingServiceClient;
	private UserRepository userRepository;
	//constructor injection
	public UserServiceImpl(HotelServiceClient hotelServiceClient, RatingServiceClient ratingServiceClient,
			UserRepository userRepository) {
		super();
		this.hotelServiceClient = hotelServiceClient;
		this.ratingServiceClient = ratingServiceClient;
		this.userRepository = userRepository;
	}
	
	

	@Override
	public User saveUser(User user) {
		String randonUserId= UUID.randomUUID().toString();
		user.setUserId(randonUserId);
		return userRepository.save(user);
		
	}

	
	@Override
	public List<User> getAllUser() {
	    
	    List<User> users = userRepository.findAll();
	    
	    return users.stream().map(user -> {
	        // fetch ratings for each user
	        List<Rating> ratings = ratingServiceClient.getRatingsByUserId(user.getUserId());
	        
	        // fetch hotel for each rating
	        ratings = ratings.stream().map(rating -> {
	            Hotel hotel = hotelServiceClient.getHotel(rating.getHotelId());
	            rating.setHotel(hotel);
	            return rating;
	        }).collect(Collectors.toList());
	        
	        // set ratings inside user
	        user.setRatings(ratings);
	        
	        return user;
	    }).collect(Collectors.toList());
	}

	@Override
	public User getUser(String userId) {
		
		User user =  userRepository
				.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User with give id is not found"+userId));
		
		//feching rating from RatingServiceClient
		
		List<Rating> ratings = ratingServiceClient.getRatingsByUserId(userId);
				
				//for each rating fetch hotels
				
				ratings = ratings.stream().map(rating -> {
					Hotel hotel = hotelServiceClient.getHotel(rating.getHotelId());
					rating.setHotel(hotel);
					return rating;
				}).collect(Collectors.toList());
		user.setRatings(ratings);
		return user;
		
	}



	@Override
	public void deleteUser(String userId) {
		User user = userRepository
				.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found With this Id"+userId));
		        userRepository.delete(user);
	}



	@Override
	public User updateUser(User user, String userId) {
	   User existingUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found With this Id"+userId));
       
	   existingUser.setName(user.getName());
	   existingUser.setEmail(user.getEmail());
	   existingUser.setAbout(user.getAbout());
	   return userRepository.save(existingUser);
		
	}

}
