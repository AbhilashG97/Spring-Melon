package com.abhilash.customlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.abhilash.customlogin.model.User;
import com.abhilash.customlogin.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/api/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
}
