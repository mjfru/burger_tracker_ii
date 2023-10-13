package com.codingdojo.burgerTracker.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.burgerTracker.models.Burger;
import com.codingdojo.burgerTracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;
	
	// Read (all)
	@GetMapping("/")
	public String index(
			@ModelAttribute("burger") Burger burger, 
			Model model) {
		ArrayList<Burger> burgers = burgerService.getAllBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
	// Create
	@PostMapping("/burger")
	public String createBurger(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result ) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	
	// Update
	// Renders the edit page and populates the form
	@GetMapping("/burger/edit/{id}")
	public String edit(
			Model model, @PathVariable("id") Long id) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	// Does the actual updating to the database
	@RequestMapping(value="/burger/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "edit.jsp";
		} else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
	
}
