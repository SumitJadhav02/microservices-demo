package com.RatingService.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	
	public ResourceNotFoundException()
	{
		super("Resource not Found with this Id");
	}
}
