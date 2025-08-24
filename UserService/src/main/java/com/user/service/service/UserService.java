package com.user.service.service;

import java.util.List;

import com.user.service.entity.User;


public interface UserService {

	
	 User saveUser(User user);
	
	 List<User> getAllUser();
	
	 User getUser(String userId);
	 
	 void deleteUser(String userId);
	 
	 User updateUser(User user, String userId);
	 
	
	
	
}
