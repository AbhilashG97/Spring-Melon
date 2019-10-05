package com.fruitdessertapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitdessertapi.model.Fruit;
import com.fruitdessertapi.repository.FruitRepository;

@Service
public class FruitService {
	
	@Autowired
	private FruitRepository fruitRepository;
	
	public ArrayList<Fruit> getAllFruits() {
		ArrayList<Fruit> fruits = new ArrayList<>();
		fruitRepository.findAll().forEach(fruits::add);
		return fruits;
	}
	
	public Fruit getFruit(int fruitID) {
		return fruitRepository.findById(fruitID).get();
	}
	
	public void updateFruit(Fruit fruit) {
		fruitRepository.save(fruit);
	}
	
	public void deleteFruit(int fruitID) {
		fruitRepository.deleteById(fruitID);
	}
	
	public void addFruit(Fruit fruit) {
		fruitRepository.save(fruit);
	}
}
