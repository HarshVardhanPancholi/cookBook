package com.cookbook.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cookbook.be.model.entities.User;
import com.cookbook.be.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired UserService userService;
	
	@PostMapping(value="/createUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User usr = userService.createUser(user);
		ResponseEntity<User> rentity = new ResponseEntity<User>(usr,HttpStatus.CREATED);
		return rentity;
	}
	
	@PostMapping(value="/auth")
	public ResponseEntity<User> authUser(@RequestBody User user){
		User usr = userService.authenticateUser(user);
		ResponseEntity<User> rentity = new ResponseEntity<User>(usr,HttpStatus.ACCEPTED);
		return rentity;

	}
}
