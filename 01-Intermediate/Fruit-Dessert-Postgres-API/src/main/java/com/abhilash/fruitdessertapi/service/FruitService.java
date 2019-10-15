package com.abhilash.fruitdessertapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhilash.fruitdessertapi.model.Fruit;
import com.abhilash.fruitdessertapi.repository.FruitRepository;

@Service
public class FruitService {
	
	@Autowired
	FruitRepository fruitRepository;
	
	public List<Fruit> getAllFruits() {
		return fruitRepository.findAll();
	}
	
	public void saveFruit(Fruit fruit) {
		fruitRepository.save(fruit);
	}
	
	public Fruit getFruit(int id) {
		return fruitRepository.findById(id).get();
	}
	
	public void deleteFruitById(int id) {
		fruitRepository.deleteById(id);
	}
}
