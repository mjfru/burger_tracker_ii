package com.codingdojo.burgerTracker.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgerTracker.models.Burger;
import com.codingdojo.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	// Create
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	// Read All
	public ArrayList<Burger> getAllBurgers() {
		return burgerRepository.findAll();
		}
	
	// Read One
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	
	// Update
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}
