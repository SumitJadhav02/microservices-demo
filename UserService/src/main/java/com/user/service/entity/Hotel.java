package com.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String about;
}
