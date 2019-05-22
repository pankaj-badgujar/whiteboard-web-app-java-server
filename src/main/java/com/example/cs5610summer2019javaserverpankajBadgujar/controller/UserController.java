package com.example.cs5610summer2019javaserverpankajBadgujar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

		users.add(new User(123, "alice", "Alice", "Lovelace", Role.FACULTY));
		users.add(new User(234, "bob", "Bob", "Anderson", Role.ADMIN));
		users.add(new User(345, "charlie", "Charlie", "Thompson", Role.FACULTY));
		users.add(new User(456, "dan", "Dan", "Nicholson", Role.STUDENT));

	}

	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return users;

	}

	@GetMapping("/api/users/{id}")
	public User findUserById(@PathVariable("id") String id) {
		long idLong = Long.parseLong(id);

		for (User u : users) {
			if (u.getId() == idLong) {
				return u;
			}
		}
		return null;
	}

	@PutMapping("/api/users/{id}")
	public List<User> updateUser(@PathVariable("id") String id, @RequestBody User newUser) {
		User userToBeUpdated = findUserById(id);
		if (userToBeUpdated != null) {
			userToBeUpdated.setUsername(newUser.getUsername());
			userToBeUpdated.setFirstName(newUser.getFirstName());
			userToBeUpdated.setLastName(newUser.getLastName());
			userToBeUpdated.setRole(newUser.getRole());

			return users;
		}
		return null;
	}

	@PostMapping("/api/users")
	public List<User> createUser(@RequestBody User user) {
		users.add(user);
		return users;
	}

	@DeleteMapping("/api/users/{id}")
	public List<User> deleteUser(@PathVariable String id) {
		User userToBeDeleted = findUserById(id);
		if (userToBeDeleted != null) {
			users.remove(userToBeDeleted);
		}
		return users;
	}

	@PutMapping("/api/users/")
	public List<User> searchUser(@RequestBody User userToBeFound) {
		return checkUsername(users, userToBeFound);
	}

	private List<User> checkUsername(List<User> usersToCheck, User userToBeFound) {
		String username = userToBeFound.getUsername();
		if ((username.equalsIgnoreCase(""))) {
			return checkFirstName(usersToCheck, userToBeFound);
		} else {
			List<User> furtherUsers = usersToCheck.stream().filter(u -> u.getUsername().equalsIgnoreCase(username))
					.collect(Collectors.toList());

			if (furtherUsers.size() == 0) {
				return null;
			} else {
				return checkFirstName(furtherUsers, userToBeFound);
			}
		}
	}

	private List<User> checkFirstName(List<User> usersToCheck, User userToBeFound) {
		String firstName = userToBeFound.getFirstName();
		if ((firstName.equalsIgnoreCase(""))) {
			return checkLastName(usersToCheck, userToBeFound);
		} else {
			List<User> furtherUsers = usersToCheck.stream().filter(u -> u.getFirstName().equalsIgnoreCase(firstName))
					.collect(Collectors.toList());

			if (furtherUsers.size() == 0) {
				return null;
			} else {
				return (checkLastName(furtherUsers, userToBeFound));
			}
		}
	}

	private List<User> checkLastName(List<User> usersToCheck, User userToBeFound) {
		String lastName = userToBeFound.getLastName();
		if ((lastName.equalsIgnoreCase(""))) {
			return checkRole(usersToCheck, userToBeFound);
		} else {
			List<User> furtherUsers = usersToCheck.stream().filter(u -> u.getLastName().equalsIgnoreCase(lastName))
					.collect(Collectors.toList());

			if (furtherUsers.size() == 0) {
				return null;
			} else {
				return (checkRole(furtherUsers, userToBeFound));
			}
		}
	}

	private List<User> checkRole(List<User> usersToCheck, User userToBeFound) {
		Role role = userToBeFound.getRole();

		List<User> furtherUsers = usersToCheck
				.stream()
				.filter(u -> u.getRole() == role)
				.collect(Collectors.toList());

		if (furtherUsers.size() == 0) {
			return null;
		} else {
			return furtherUsers;
		}

	}
}
