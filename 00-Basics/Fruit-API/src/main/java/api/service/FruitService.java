package api.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Fruit;

@Service
public class FruitService {

	private ArrayList<Fruit> fruits = new ArrayList<Fruit>() {{
		add(new Fruit("Watermelon", 100));
		add(new Fruit("Apple", 140));
		add(new Fruit("Orange", 350));
		add(new Fruit("Mango", 500));
		add(new Fruit("Dragon-fruit", 200));
		add(new Fruit("Soursop", 1200));
		add(new Fruit("Star-fruit", 145));
		add(new Fruit("Sweet Lime", 123));
	}};
	
	public ArrayList<Fruit> getFruits() {
		return fruits;
	}
	
	public Fruit getFruit(String fruit) {
		return fruits.stream().filter((fruitValue) -> fruitValue.getName().toLowerCase().equals(fruit.toLowerCase()))
				.findFirst().get();
	}

	public void addFruit(Fruit fruit) {
		fruits.add(fruit);
	}

	public void updateFruit(String fruitName, Fruit fruit) {
        fruits = fruits.stream()
		.map(fruitValue -> fruitValue.getName().toLowerCase().equals(fruitName.toLowerCase()) ? fruit : fruitValue)
		.collect(Collectors.toCollection(ArrayList::new));
	}

	public void deleteFruit(String fruitName) {
		fruits.removeIf(fruit -> fruit.getName().toLowerCase().equals(fruitName.toLowerCase()));
	}
	
}
