package com.fruitapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitapi.model.Fruit;
import com.fruitapi.repositories.FruitRepository;

@Service
public class FruitService {

	@Autowired
	private FruitRepository fruitRepository;
	
	public void addFruit(Fruit fruit) {
		fruitRepository.save(fruit);
	}
	
	public ArrayList<Fruit> getAllFruits() {
		ArrayList<Fruit> fruits = new ArrayList<>();
		fruitRepository.findAll().forEach(fruits::add);
		return fruits;
	}
	
	public Fruit getFruit(String fruitName) {
		return fruitRepository.findById(fruitName).get();
	}
	
	public void updateFruit(Fruit fruit) {
		fruitRepository.save(fruit);
	}
	
	public void deleteFruit(String fruit) {
		fruitRepository.deleteById(fruit);
	}
}
