package com.service.HotelService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="micro_hotels")
public class Hotel {

	@Id
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String about;
}
