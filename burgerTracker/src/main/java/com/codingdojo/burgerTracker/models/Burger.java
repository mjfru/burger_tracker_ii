package com.codingdojo.burgerTracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="burgers")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Field cannot be blank.")
	private String burgerName;
	
	@NotBlank(message="Field cannot be blank.")
	private String restaurant;
	
	@NotNull(message="You must provide a rating.")
	@Min(value = 1, message="Rating must be between 1 and 5.")
	@Max(value = 5, message="Rating must be between 1 and 5.")
	private Integer rating;
	
	@NotBlank(message="Field cannot be blank.")
	private String notes;
	
	// Empty Constructor:
	public Burger() {
	}
	
	// Constructor w/ fields:
	public Burger(String burgerName, String restaurant, Integer rating, String notes) {
		this.burgerName = burgerName;
		this.restaurant = restaurant;
		this.rating = rating;
		this.notes = notes;
	}
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	// Getters and Setters:
	public Long getId() {		// Forgot the id getters and setters - caused a big error - remember for next time
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}


