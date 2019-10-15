package com.fruitdessertapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.fruitdessertapi.model.Fruit;

public interface FruitRepository extends CrudRepository<Fruit, Integer> {
	
}
