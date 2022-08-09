package com.cookbook.be.model.entities;

import javax.persistence.*;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long recipeId;
	@Column(name = "recipe")
	private String recipe;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	public Recipe() {
		// TODO Auto-generated constructor stub
	}
	
	public Recipe(long recipeId, String recipe, User user) {
		this.recipeId = recipeId;
		this.recipe = recipe;
		this.user = user;
	}
	public long getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
