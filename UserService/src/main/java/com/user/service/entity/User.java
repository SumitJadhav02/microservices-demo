package com.user.service.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="micro_users")
public class User {

	@Id
	@Column(name="userId")
	private String userId;
	
	private String name;
	
	private String email;
	
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
	
}
