package com.mashupstack.recipe_sharing.repository;


import com.mashupstack.recipe_sharing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    //User findByUsername(String username);

    Optional<User> findOneByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
