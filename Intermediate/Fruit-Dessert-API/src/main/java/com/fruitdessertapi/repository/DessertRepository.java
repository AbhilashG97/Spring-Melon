package com.fruitdessertapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.fruitdessertapi.model.Dessert;

public interface DessertRepository extends CrudRepository<Dessert, Integer> {

}
