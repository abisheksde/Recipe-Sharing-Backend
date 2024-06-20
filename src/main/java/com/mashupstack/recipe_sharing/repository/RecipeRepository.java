package com.mashupstack.recipe_sharing.repository;

import com.mashupstack.recipe_sharing.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Iterable<Recipe> findByUsername(String username);

    //Optional<Recipe> findByDifficulty(String difficulty);
/*
    @Query("SELECT b FROM Blog b WHERE b.title LIKE %:keyword% OR b.content LIKE %:keyword%")
    List<Recipe> findByKeyword(@Param("keyword") String keyword);*/
}

