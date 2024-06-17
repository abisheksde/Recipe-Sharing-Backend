package com.mashupstack.recipe_sharing.repository;

import com.mashupstack.recipe_sharing.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Iterable<Recipe> findByUsername(String username);

    Optional<Recipe> findByDifficulty(String difficulty);
}

