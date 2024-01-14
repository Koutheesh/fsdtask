package com.example.userreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userreg.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByEmail(String email);
	
	public User findByEmail(String email);
    
}
