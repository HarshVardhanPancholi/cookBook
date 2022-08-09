package com.cookbook.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.be.model.entities.Recipe;
import com.cookbook.be.model.entities.User;

public interface RecipeRepo extends JpaRepository<Recipe, Long>{
	Optional<Recipe> findByUser(User user);
}
