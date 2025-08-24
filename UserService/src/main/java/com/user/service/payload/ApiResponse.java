package com.user.service.payload;

import org.springframework.http.HttpStatus;

import com.user.service.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;

}
