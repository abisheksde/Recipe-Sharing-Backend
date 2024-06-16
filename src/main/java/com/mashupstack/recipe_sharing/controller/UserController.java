package com.mashupstack.recipe_sharing.controller;


import com.mashupstack.recipe_sharing.dto.UserDTO;
import com.mashupstack.recipe_sharing.models.User;
import com.mashupstack.recipe_sharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {

        User user = new User(userDTO.getFullname(), userDTO.getUsername() , passwordEncoder.encode(userDTO.getPassword()));

        User user1 =  userRepository.save(user);
        //return ResponseEntity.ok(user1).getBody();

        return user1;
    }
}
