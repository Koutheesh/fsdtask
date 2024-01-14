package com.example.userreg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.userreg.model.User;
import com.example.userreg.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute("user") User user,HttpSession session) {
    	
    	boolean f = userService.checkEmai(user.getEmail()); 
    	if(f) {
    		System.out.println("Email already exists");
    		session.setAttribute("msg", "Email already exists");
    	}
    	else {
    		user=userService.saveUser(user);
    		if(user!=null) {
    	    	   System.out.println("Success");
    	    	   session.setAttribute("msg", "Registraion Success");
    	       }
    	       else {
    	    	   System.out.println("Something went worng");
    	    	   session.setAttribute("msg", "Something went worong");
    	       }
    	}
       
       
        return "redirect:/signup";
    }
}

