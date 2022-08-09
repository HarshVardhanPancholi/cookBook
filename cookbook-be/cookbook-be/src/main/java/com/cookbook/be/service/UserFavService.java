package com.cookbook.be.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.be.exception.CustomException;
import com.cookbook.be.model.entities.User;
import com.cookbook.be.model.entities.UserFavorite;
import com.cookbook.be.repository.UserFavoriteRepo;
import com.cookbook.be.repository.UserRepo;

@Service
public class UserFavService {

	@Autowired
	UserFavoriteRepo repo;
	@Autowired
	UserRepo userRepo;
	
	public UserFavorite createFav(UserFavorite userFavorite) {
		UserFavorite result = repo.save(userFavorite);
		return result;
	}
	
	public List<UserFavorite> getFavByUser(long id){
		User user =userRepo.findById(id).get();
		List<UserFavorite> result = new ArrayList<UserFavorite>();
		if(user != null) {
			result=repo.findByUser(user);
		}
		return result;
	}
	
	public void deleteFav(long id) {
		UserFavorite value = repo.findById(id).orElseThrow(()->new CustomException("Selected favorite is not present"));
		repo.delete(value);
	}
}
