package com.cookbook.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.be.model.entities.User;
import com.cookbook.be.model.entities.UserFavorite;

public interface UserFavoriteRepo extends JpaRepository<UserFavorite,Long>{
	List<UserFavorite> findByUser(User user);
}
