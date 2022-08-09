package com.cookbook.be.model.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userFavoriteId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_Id")
	private Recipe recipe;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;
	
	public UserFavorite() {
		// TODO Auto-generated constructor stub
	}

	public UserFavorite(long userFavoriteId, Recipe recipe, User user) {
		this.userFavoriteId = userFavoriteId;
		this.recipe = recipe;
		this.user = user;
	}

	public long getUserFavoriteId() {
		return userFavoriteId;
	}

	public void setUserFavoriteId(int userFavoriteId) {
		this.userFavoriteId = userFavoriteId;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}