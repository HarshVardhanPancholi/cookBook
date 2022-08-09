package com.cookbook.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.be.service.RecipeService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/recipe")
public class RecipeController {
	@Autowired RecipeService service;
	
	
}
