package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	

}
