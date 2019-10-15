package com.abhilash.fruitdessertapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhilash.fruitdessertapi.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
	
}
