package com.jey.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jey.user.model.User;

@Controller
public class UserController {
	private List<User> userList;
	
    public UserController() {
        // Initialize some dummy users
        userList = new ArrayList<>();
        userList.add(new User(1, "Mohan Raju", "Architect, Development", "mohan.raju@aptean.com", "Bangalore, India", "Geeta Karanjkar"));
        userList.add(new User(2, "Shreyash", "Engineer, Development", "shreyash.borkar@aptean.com", "Bangalore, India", "Vidhya Murugesan"));
        userList.add(new User(3, "Akhila", "Associate Engineer, Development", "gollapalli.akhila@aptean.com", "Bangalore, India", "Vidhya Murugesan"));
        userList.add(new User(4, "Jeysiva", "Associate Engineer, Development", "jeysiva.panchanathan@aptean.com", "Madurai, India", "Vidhya Murugesan"));
    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userList);
        return "home.html";
    }
    
    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable int id, Model model) {
        User user = getUserById(id);
        model.addAttribute("user", user);
        return "userDetails.html";
    }
    
    private User getUserById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
	
}
