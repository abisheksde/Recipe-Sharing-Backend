package com.mashupstack.recipe_sharing.controller;

import com.mashupstack.recipe_sharing.models.Recipe;
import com.mashupstack.recipe_sharing.models.User;
import com.mashupstack.recipe_sharing.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/list")
    public List<Recipe> getAllItems() {
        return recipeRepository.findAll();
    }

   /* @GetMapping("/search")
    public List<Recipe> getbyKeyword(@RequestParam String keyword){
        return recipeRepository.findByKeyword(keyword);
    }*/

    @PostMapping("/save")
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
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        recipe.setUsername(userEmail);*/
        return recipeRepository.save(recipe);
    }

    @GetMapping("/usersRecipes")
    public List<Recipe> getAllRecipes() {
        // Retrieve the currently authenticated user's email
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        recipes = recipeRepository.findByUsername(userEmail);
        */

        // Retrieve product list based on the user's email

        return recipeRepository.findAll(); // (X)
    }

    @GetMapping("/update/{id}")
    public Recipe updateProduct(@PathVariable Long id) {
        Optional<Recipe> optionalRecipeDetails = recipeRepository.findById(id);
        Recipe recipeDetails = optionalRecipeDetails.get();

        return recipeDetails;
    }

    @PostMapping("/update/{id}")
    public Recipe updateRecipe(@PathVariable Long id,
                                @RequestParam String title,
                                @RequestParam String ingredients,
                                @RequestParam String steps,
                                @RequestParam String cookingTime,
                                @RequestParam String difficulty,
                                @RequestParam(required = false) MultipartFile image) throws Exception {

        Optional<Recipe> optionalRecipeDetails = recipeRepository.findById(id);
        //Optional<Recipe> optionalRecipeDetails = recipeRepository.findByDifficulty(difficulty);
        if(optionalRecipeDetails.isPresent()){
            Recipe recipeDetails = optionalRecipeDetails.get();
            recipeDetails.setTitle(title);
            recipeDetails.setIngredients(ingredients);
            recipeDetails.setSteps(steps);
            recipeDetails.setCookingTime(cookingTime);
            recipeDetails.setDifficulty(difficulty);
            recipeDetails.setIngredients(ingredients);
            if (image != null) {
                recipeDetails.setImage(image.getBytes());
            }

            return recipeRepository.save(recipeDetails);
        } else {
            throw new RuntimeException("Recipe not found");
        }
    }

    @GetMapping("/delete/")
    public Recipe deleteProduct(@PathVariable Long id) {
        Optional<Recipe> optionalRecipeDetails = recipeRepository.findById(id);
        Recipe recipeDetails = optionalRecipeDetails.get();

        return recipeDetails;
    }

    @PostMapping("/delete/{id}") // {id}
    public String deleteProducts(@PathVariable Long id) {
        if (id != null) {
            recipeRepository.deleteById(id);
            //recipeRepository.deleteAll();

            return "redirect:/";
        }
        return "delete";
    }
}
