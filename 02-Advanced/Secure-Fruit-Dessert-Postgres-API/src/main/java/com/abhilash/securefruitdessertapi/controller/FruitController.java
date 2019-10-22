package com.abhilash.securefruitdessertapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.abhilash.securefruitdessertapi.model.Fruit;
import com.abhilash.securefruitdessertapi.service.FruitService;

@RestController()
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/fruits")
	public List<Fruit> getFruits() {
		return fruitService.getAllFruits();
	}
	
	@RequestMapping("/fruits/fruit/{id}")
	public Fruit getFruit(@PathVariable int id) {
		return fruitService.getFruit(id);
	}
	
	@DeleteMapping("/fruits")
	public void deleteFruit(@RequestBody int id) {
		fruitService.deleteFruit(id);
	}
	
	@PostMapping("/fruits")
	public void updateFruit(@RequestBody Fruit fruit) {
		fruitService.saveFruit(fruit);
	}
	
	@PutMapping("/fruits")
	public void addFruit(@RequestBody Fruit fruit) {
		fruitService.saveFruit(fruit);
	}
}
