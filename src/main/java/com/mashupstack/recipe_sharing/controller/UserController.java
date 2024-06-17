package com.mashupstack.recipe_sharing.controller;


import com.mashupstack.recipe_sharing.response.LoginResponse;
import com.mashupstack.recipe_sharing.dto.LoginDTO;
import com.mashupstack.recipe_sharing.dto.UserDTO;
import com.mashupstack.recipe_sharing.models.User;
import com.mashupstack.recipe_sharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    /*@GetMapping("/login")
    public String login() {
        return "login";
    }*/
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        String msg = " ";
        LoginResponse loginResponse;

        User user = userRepository.findByUsername(loginDTO.getUsername());

        System.out.println(loginDTO.getUsername());

        if (user != null){
            String userPassword = loginDTO.getPassword();
            String encodedPassword = user.getPassword();

            boolean isCorrectPassword =  passwordEncoder.matches(userPassword, encodedPassword);

            if(isCorrectPassword){
                Optional<User> loginUser = userRepository.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);

                if (loginUser.isPresent()){
                     loginResponse =  new LoginResponse(true, "Login Success");
                } else {
                     loginResponse =    new LoginResponse(false, "Login Failed");
                }
            } else {
                 loginResponse =    new LoginResponse(false, "Incorrect Password");
            }
        } else {
             loginResponse =    new LoginResponse(false, "User does not Exist");
        }

        return ResponseEntity.ok(loginResponse);

    }


}
