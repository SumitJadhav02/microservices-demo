package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.external.services.RatingServiceClient;
import com.user.service.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private RatingServiceClient ratingService;
	
	UserServiceImpl userServiceImpl;
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}


	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1 = userServiceImpl.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable("userId") String userId)
	{
		User oneUser = userServiceImpl.getUser(userId);
		return ResponseEntity.ok(oneUser);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> AllUser = userServiceImpl.getAllUser();
		return ResponseEntity.ok(AllUser);
	}
	
	@GetMapping("/{userId}/ratings")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("userId") String userId) {
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(ratings);
    }
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
	    userServiceImpl.deleteUser(userId);
	    return ResponseEntity.noContent().build(); // HTTP 204 No Content
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId , @RequestBody User user)
	{
		User updatedUser = userServiceImpl.updateUser(user, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	


}
