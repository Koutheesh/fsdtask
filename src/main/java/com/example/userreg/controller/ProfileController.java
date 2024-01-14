package com.example.userreg.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.userreg.model.User;
import com.example.userreg.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {
	
	@GetMapping("/profileUpdate")
    public String saveUser(@ModelAttribute("user") User user,HttpSession session) {
    	
    	System.out.println(user.getEmail());
    	return "redirect:/profile";
   
    
    }

}
