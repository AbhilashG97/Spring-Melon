package com.abhilash.securefruitdessertapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhilash.securefruitdessertapi.model.Fruit;
import com.abhilash.securefruitdessertapi.repository.FruitRepository;

@Service
public class FruitService {

	@Autowired
	private FruitRepository fruitRepository;
	
	public List<Fruit> getAllFruits() {
		return fruitRepository.findAll();
	}
	
	public Fruit getFruit(int id) {
		return fruitRepository.findById(id).get();
	}
	
	public void deleteFruit(int id) {
		fruitRepository.deleteById(id);
	}
	
	public void saveFruit(Fruit fruit) {
		fruitRepository.save(fruit);
	}
	
}
