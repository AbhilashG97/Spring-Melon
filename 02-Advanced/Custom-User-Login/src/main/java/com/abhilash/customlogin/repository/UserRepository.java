package com.abhilash.customlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhilash.customlogin.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
