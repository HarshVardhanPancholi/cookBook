package com.cookbook.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.be.exception.CustomException;
import com.cookbook.be.model.entities.User;
import com.cookbook.be.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User createUser(User user) {
		User result = userRepo.save(user);
		return result;
	}
	
	public User authenticateUser(User user){
		User result = userRepo.findByUserName(user.getUserName()).orElseThrow(()->new CustomException("UserName is incorrect"));
		if(result.getPassword().equals(user.getPassword())) {
			return result;
		}
		throw new CustomException("Password is incorrect");
	}
}
