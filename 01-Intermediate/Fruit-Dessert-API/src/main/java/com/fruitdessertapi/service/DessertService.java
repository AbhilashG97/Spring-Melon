package com.fruitdessertapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitdessertapi.model.Dessert;
import com.fruitdessertapi.repository.DessertRepository;

@Service
public class DessertService {
	
	@Autowired
	private DessertRepository dessertRepository;

	public ArrayList<Dessert> getDesserts(int fruitId) {
		return dessertRepository.findByFruitId(fruitId);
	}
	
	public Dessert getDessert(int dessertID) {
		return dessertRepository.findById(dessertID).get();
	}
	
	public void addDessert(Dessert dessert) {
		dessertRepository.save(dessert);
	}
	
	public void updateDessert(Dessert dessert) {
		dessertRepository.save(dessert);
	}
	
	public void deleteDessert(int dessertID) {
		dessertRepository.deleteById(dessertID);
	}

}