package com.fruitapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruitapi.model.Fruit;
import com.fruitapi.service.FruitService;

@RestController
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello, World!";
	}
	
	@RequestMapping("/fruits")
	public ArrayList<Fruit> getAllFruits() {
		return fruitService.getAllFruits();
	}
	
	@RequestMapping("fruits/{fruitName}")
	public Fruit getFruit(@PathVariable String fruitName) {
		return fruitService.getFruit(fruitName);
	}
	
	@PostMapping("/fruits")
	public void addFruit(@RequestBody Fruit fruit) {
		fruitService.addFruit(fruit);
	}
	
	@PutMapping("/fruits")
	public void updateFruit(@RequestBody Fruit fruit) {
		fruitService.updateFruit(fruit);
	}
	
	@DeleteMapping("/fruits/{fruitName}")
	public void deleteFruit(@PathVariable String fruitName) {
		fruitService.deleteFruit(fruitName);
	}
	
}
