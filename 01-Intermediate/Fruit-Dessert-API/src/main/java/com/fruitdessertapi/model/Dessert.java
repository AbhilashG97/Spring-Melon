package com.fruitdessertapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dessert {

	@Id
	private int id;
	
	@ManyToOne
	private Fruit fruit;
	
	private String name;
	private String description;
	private int price;
	
	public Dessert() {
		super();
	}

	public Dessert(int id, Fruit fruit, String name, String description, int price) {
		super();
		this.id = id;
		this.fruit = fruit;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Dessert [id=" + id + ", fruit=" + fruit + ", name=" + name + ", description=" + description + ", price="
				+ price + "]";
	}
	
}
