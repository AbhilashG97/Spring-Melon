package data;

import java.util.ArrayList;

import model.Fruit;


public class FruitData {
		
	private ArrayList<Fruit> fruits;
	private static FruitData fruitData;
	
	private FruitData() {
		fruits = new ArrayList<>();
	}
	
	public static FruitData getInstance() {
		if(fruitData == null) {
			fruitData = new FruitData();
		}
		
		return fruitData;
	}
	
	public ArrayList<Fruit> getFruits() {
		fruits.add(new Fruit("Watermelon", 100));
		fruits.add(new Fruit("Apple", 140));
		fruits.add(new Fruit("Orange", 350));
		fruits.add(new Fruit("Mango", 500));
		fruits.add(new Fruit("Dragon-fruit", 200));
		fruits.add(new Fruit("Soursop", 1200));
		fruits.add(new Fruit("Star-fruit", 145));
		fruits.add(new Fruit("Sweet Lime", 123));
		return fruits;
	}
	
}
