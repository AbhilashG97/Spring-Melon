package com.fruitdessertapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruitdessertapi.model.Fruit;
import com.fruitdessertapi.service.FruitService;

@RestController
public class FruitController {

	@Autowired
	private FruitService fruitService;
	
	@RequestMapping("")
	public String sayHello() {
		ArrayList<Fruit> fruits = new ArrayList<Fruit>() {{
			add(new Fruit(0, "watermelon", 120));
			add(new Fruit(1, "mango", 100));
			add(new Fruit(2, "lychee", 220));
			add(new Fruit(3, "apple", 320));
			add(new Fruit(4, "kiwi", 125));
			add(new Fruit(5, "soursop", 1205));
			add(new Fruit(6, "sapote", 12045));
		}};
		
		for (Fruit fruit : fruits) {
			fruitService.addFruit(fruit);
		}
		
		return "Hello, world!";
	}
	
	@RequestMapping("/fruits")
	public ArrayList<Fruit> getAllFruits() {
		return fruitService.getAllFruits();
	}
	
	@RequestMapping("/fruits/{id}")
	public Fruit getFruit(@PathVariable int id) {
		return fruitService.getFruit(id);
	}
	
	@PostMapping(value="/fruits")
	public void addFruit(@RequestBody Fruit fruit) {
		fruitService.addFruit(fruit);
	}
	
	@PutMapping("/fruits")
	public void updateFruit(@RequestBody Fruit fruit) {
		fruitService.updateFruit(fruit);
	}
	
	@DeleteMapping("/fruits/{id}")
	public void deleteFruit(@PathVariable int id) {
		fruitService.deleteFruit(id);
	}
}
