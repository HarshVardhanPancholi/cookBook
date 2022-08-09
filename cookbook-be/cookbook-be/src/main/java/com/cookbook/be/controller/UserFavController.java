package com.cookbook.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.be.model.entities.UserFavorite;
import com.cookbook.be.service.UserFavService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/fav")
public class UserFavController {
	@Autowired UserFavService service;
	
	@PostMapping(value="/createFav")
	public ResponseEntity<UserFavorite> addFav(@RequestBody UserFavorite userFavorite){
		UserFavorite usr = service.createFav(userFavorite);
		ResponseEntity<UserFavorite> rentity = new ResponseEntity<UserFavorite>(usr,HttpStatus.CREATED);
		return rentity;
	}
	
	@GetMapping(value="/fetchFav/{id}")
	public ResponseEntity<List<UserFavorite>> fetchFav(@PathVariable Long id){
		List<UserFavorite> usr = service.getFavByUser(id);
		ResponseEntity<List<UserFavorite>> rentity = new ResponseEntity<List<UserFavorite>>(usr,HttpStatus.CREATED);
		return rentity;
	}
	
	@DeleteMapping(value="/removeFav/{id}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeFav(@PathVariable Long id) {
		service.deleteFav(id);
	}
}
