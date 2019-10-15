package com.abhilash.fruitdessertapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhilash.fruitdessertapi.model.Fruit;
import com.abhilash.fruitdessertapi.service.FruitService;

@Controller
public class FruitController {

	@Autowired
	private FruitService fruitService;
	
	@RequestMapping("/")
	public ModelAndView showHomePage(Model model) {
		model.addAttribute("listFruits", fruitService.getAllFruits());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/new") 
	public String showAddFruitPage(Model model) {
		model.addAttribute("fruit",new Fruit());
		return "add_fruit";
	}
	
	@PostMapping("/save")
	public String saveFruit(@ModelAttribute("fruit") Fruit fruit) {
		fruitService.saveFruit(fruit);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditFruitPage(@PathVariable int id, Model model) {
		model.addAttribute("fruit", fruitService.getFruit(id));
		return "edit_fruit";
	}
	
	@RequestMapping("/delete/{id}") 
	public String deleteFruit(@PathVariable int id) {
		fruitService.deleteFruitById(id);
		return "redirect:/";
	}
	
}
