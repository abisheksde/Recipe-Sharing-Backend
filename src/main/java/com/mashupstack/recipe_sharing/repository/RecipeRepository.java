package com.mashupstack.recipe_sharing.repository;

import com.mashupstack.recipe_sharing.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}

