package com.mashupstack.recipe_sharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
		//(scanBasePackages={"com.mashupstack.recipe_sharing.service.UserService"})
//Field userService in com.mashupstack.recipe_sharing.controller.UserController required a bean of type 'com.mashupstack.recipe_sharing.service.UserService' that could not be found.
public class RecipeSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSharingApplication.class, args);
	}

}
