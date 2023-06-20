package com.jey.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jey.user.model.User;
import com.jey.user.repository.UserRepository;

@Controller
public class UserController {

    UserRepository userRepository = new UserRepository();
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userRepository.getUserList());
        return "home.html";
    }
    
    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable int id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        return "userDetails.html";
    }

}
