package com.cookbook.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.be.exception.CustomException;
import com.cookbook.be.model.entities.Recipe;
import com.cookbook.be.model.entities.User;
import com.cookbook.be.repository.RecipeRepo;
import com.cookbook.be.repository.UserRepo;

@Service
public class RecipeService {

	@Autowired
	RecipeRepo repo;
	@Autowired
	UserRepo userRepo;
	
	public Recipe createRecipe(Recipe recipe) {
		Recipe result = repo.save(recipe);
		return result;
	}
	public Recipe fetchRecipe(long id) {
		User user =userRepo.findById(id).get();
		Recipe result = new Recipe();
		if(user != null) {
			result=repo.findByUser(user).get();
		}
		return result;
	}
	public void deleteRecipe(long id) {
		Recipe value = repo.findById(id).orElseThrow(()->new CustomException("Selected recipe is not present"));
		repo.delete(value);
	}
}
