package com.abhilash.securefruitdessertapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhilash.securefruitdessertapi.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Integer>{

}
