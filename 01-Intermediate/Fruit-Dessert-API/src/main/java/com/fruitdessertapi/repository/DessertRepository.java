package com.fruitdessertapi.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.fruitdessertapi.model.Dessert;

public interface DessertRepository extends CrudRepository<Dessert, Integer> {
	
	ArrayList<Dessert> findByFruitId(int fruitId);
	
}
