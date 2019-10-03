package api.contoller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.service.FruitService;
import data.FruitData;
import model.Fruit;

@RestController
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	
	@RequestMapping("")
	public String sayHello() {
		return "Hello, World!";
	}
	
	@RequestMapping("/fruits")
	public ArrayList<Fruit> getFruitData() {
		return fruitService.getFruits();
	}
	
	@RequestMapping("/fruits/{fruit}")
	public Fruit getFruit(@PathVariable String fruit) {
		return fruitService.getFruit(fruit);
	}
	
	@RequestMapping(value="/fruits", method=RequestMethod.POST)
	public void addFruit(@RequestBody Fruit fruit) {
		fruitService.addFruit(fruit);
	}
	
	@RequestMapping(value="/fruits/{fruitName}", method=RequestMethod.PUT)
	public void updateFruit(@PathVariable String fruitName, @RequestBody Fruit fruit) {
		fruitService.updateFruit(fruitName, fruit);
	}
	
	@RequestMapping(value="/fruits/{fruitName}", method=RequestMethod.DELETE)
	public void deleteFruit(@PathVariable String fruitName) {
		fruitService.deleteFruit(fruitName);
	}
	
}
