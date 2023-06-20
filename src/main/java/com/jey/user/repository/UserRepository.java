package com.jey.user.repository;

import java.util.ArrayList;
import java.util.List;

import com.jey.user.model.User;

public class UserRepository {

	private List<User> userList;

	public UserRepository() {
		userList = new ArrayList<>();
		userList.add(new User(1, "Mohan Raju", "Architect, Development", "mohan.raju@aptean.com", "Bangalore, India",
				"Geeta Karanjkar"));
		userList.add(new User(2, "Shreyash", "Engineer, Development", "shreyash.borkar@aptean.com", "Bangalore, India",
				"Vidhya Murugesan"));
		userList.add(new User(3, "Akhila", "Associate Engineer, Development", "gollapalli.akhila@aptean.com",
				"Bangalore, India", "Vidhya Murugesan"));
		userList.add(new User(4, "Jeysiva", "Associate Engineer, Development", "jeysiva.panchanathan@aptean.com",
				"Madurai, India", "Vidhya Murugesan"));
	}

	public List<User> getUserList() {
		return userList;
	}

	public User getUserById(int id) {
		return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}
}
