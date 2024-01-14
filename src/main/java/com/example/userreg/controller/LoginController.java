package com.example.userreg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.userreg.model.User;
import com.example.userreg.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/profile")
    public String saveUser(@ModelAttribute("user") User user,HttpSession session) {
    	
    	String pass = userService.findByEmail(user.getEmail()); 
    	if(pass.equals(user.getPassword())) {
    		System.out.println("Password Matched");
    		
    		return "redirect:/profileUpdate";
    	}
    	else {
    		session.setAttribute("msg", "Invalid Login Details");
    	   return "redirect:/login";
    	}
    }
}
