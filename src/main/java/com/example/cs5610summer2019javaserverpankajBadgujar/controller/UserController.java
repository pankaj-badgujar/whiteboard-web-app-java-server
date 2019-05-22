package com.example.cs5610summer2019javaserverpankajBadgujar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Role;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.User;

@RestController
public class UserController {

	static List<User> users = new ArrayList<User>();
	static {
		
		users.add(new User(123,"alice","Alice","Lovelace",Role.FACULTY));
		users.add(new User(234,"bob","Bob","Anderson",Role.ADMIN));
		users.add(new User(345,"charlie","Charlie","Thompson",Role.FACULTY));
		users.add(new User(456,"dan","Dan","Nicholson",Role.STUDENT));
		
	}

	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return users;

	}

	@GetMapping("/api/users/{id}")
	public User findUserById(@PathVariable("id") long id) {
		for(User u : users) {
			if( u.getId() == id ) {
				return u;
			}
		}
		return null;
	}
	
	@PutMapping("/api/users/{id}")
	public void updateUser(@PathVariable("id") long id, User newUser) {
		User userToBeUpdated = findUserById(id);
		if(userToBeUpdated != null) {
			userToBeUpdated.setUsername(newUser.getUsername());
			userToBeUpdated.setFirstName(newUser.getFirstName());
			userToBeUpdated.setLastName(newUser.getLastName());
			userToBeUpdated.setRole(newUser.getRole());			
		}
		
	}
	
	
	@PostMapping("/api/users")
	public List<User> createUser(@RequestBody User user) {
		users.add(user);
		return users;
	}
	
	@DeleteMapping("/api/users/{id}")
	public List<User> deleteUser(@PathVariable String id){
		long idLong = Long.parseLong(id);
		User userToBeDeleted = findUserById(idLong);
		if(userToBeDeleted != null) {
			users.remove(userToBeDeleted);
		}
		return users;
	}
	
}
