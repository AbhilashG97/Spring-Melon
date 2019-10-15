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

import com.fruitdessertapi.model.Dessert;
import com.fruitdessertapi.model.Fruit;
import com.fruitdessertapi.service.DessertService;

@RestController
public class DessertController {

	@Autowired
	private DessertService dessertService;
	
	@RequestMapping("/fruits/{fruitId}/desserts")
	public ArrayList<Dessert> getAllDesserts(@PathVariable int fruitId) {
		return dessertService.getDesserts(fruitId);
	}
	
	@RequestMapping("/fruits/{fruitID}/desserts/{id}")
	public Dessert getDessert(@PathVariable int id) {
		return dessertService.getDessert(id);
	} 
	
	@PostMapping("/fruits/{fruitID}/desserts")
	public void addDessert(@RequestBody Dessert dessert, @PathVariable int fruitID) {
		dessert.setFruit(new Fruit(fruitID, "", 0));
		dessertService.addDessert(dessert);
	}
	
	@PutMapping("/fruits/{fruitID}/desserts") 
	public void updateDessert(@RequestBody Dessert dessert, @PathVariable int fruitID) {
		dessert.setFruit(new Fruit(fruitID, "", 0));
		dessertService.updateDessert(dessert);
	}
	
	@DeleteMapping("/fruits/{fruitID}/desserts/{id}")
	public void deleteDessert(@PathVariable int id) {
		dessertService.deleteDessert(id);
	}
}
