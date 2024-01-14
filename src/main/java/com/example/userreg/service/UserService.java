package com.example.userreg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userreg.model.User;
import com.example.userreg.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		System.out.println(userRepository.findAll());
		return userRepository.findAll();
		
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void  deleteUser(User user) {
		userRepository.delete(user);
	}

	public boolean checkEmai(String email) {
		
		return userRepository.existsByEmail(email);
	}
	
	public String findByEmail(String email) {
		User user =userRepository.findByEmail(email);
		if(user!=null) {
			return user.getPassword();
		}
		else return "";
	}
	
	public User getProfile(String email) {
		
		return userRepository.findByEmail(email);
	}
	
	
}
