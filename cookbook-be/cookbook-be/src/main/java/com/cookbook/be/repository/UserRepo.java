package com.cookbook.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.be.model.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String username);
}
