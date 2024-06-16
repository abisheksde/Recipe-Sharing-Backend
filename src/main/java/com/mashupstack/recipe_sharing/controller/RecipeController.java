package com.mashupstack.recipe_sharing.controller;

import com.mashupstack.recipe_sharing.models.Recipe;
import com.mashupstack.recipe_sharing.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping
    public Recipe createRecipe(@RequestParam String title,
                               @RequestParam String ingredients,
                               @RequestParam String steps,
                               @RequestParam String cookingTime,
                               @RequestParam String difficulty,
                               @RequestParam(required = false) MultipartFile image) throws IOException {
        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setIngredients(ingredients);
        recipe.setSteps(steps);
        recipe.setCookingTime(cookingTime);
        recipe.setDifficulty(difficulty);
        if (image != null) {
            recipe.setImage(image.getBytes());
        }
        return recipeRepository.save(recipe);
    }
}
