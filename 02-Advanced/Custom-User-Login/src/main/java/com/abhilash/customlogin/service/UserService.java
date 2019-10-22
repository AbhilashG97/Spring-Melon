package com.abhilash.customlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.abhilash.customlogin.model.User;
import com.abhilash.customlogin.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Secured({"ADMIN", "USER"})
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}
