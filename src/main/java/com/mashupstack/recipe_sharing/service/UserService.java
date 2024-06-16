package com.mashupstack.recipe_sharing.service;

import com.mashupstack.recipe_sharing.models.User;
import com.mashupstack.recipe_sharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
