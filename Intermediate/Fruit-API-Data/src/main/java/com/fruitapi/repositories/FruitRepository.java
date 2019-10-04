package com.fruitapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fruitapi.model.Fruit;

public interface FruitRepository extends CrudRepository<Fruit, String> {
	
	
}
