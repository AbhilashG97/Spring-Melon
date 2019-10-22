package com.abhilash.customlogin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="users")
public class User {
	
	@Id
	private int id;
	
	private String username;
	
	private String password;
	
	private String fullname;
	
	private String role;
	
	public User() {
		super();
	}

	public User(int id, String name, String password, String fullname, String role) {
		super();
		this.id = id;
		this.username = name;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", password=" + password + ", fullname=" + fullname + ", role="
				+ role + "]";
	}
	
}
