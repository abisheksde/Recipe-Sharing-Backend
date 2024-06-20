/*
package com.mashupstack.recipe_sharing.controller;

import com.mashupstack.recipe_sharing.dto.FollowRequest;
import com.mashupstack.recipe_sharing.models.User;
import com.mashupstack.recipe_sharing.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FollowController {

    @Autowired
    private FollowRepository followRepository;

    @PostMapping("/follow")
    public ResponseEntity<?> followUser(@RequestBody FollowRequest followRequest) {
        followRepository.followUser(followRequest.getFollowerId(), followRequest.getFolloweeId());
        return ResponseEntity.ok("User followed successfully");
    }

    @PostMapping("/unfollow")
    public ResponseEntity<?> unfollowUser(@RequestBody FollowRequest followRequest) {
        followRepository.unfollowUser(followRequest.getFollowerId(), followRequest.getFolloweeId());
        return ResponseEntity.ok("User unfollowed successfully");
    }

    @GetMapping("/followers/{userId}")
    public ResponseEntity<List<User>> getFollowers(@PathVariable Long userId) {
        List<User> followers = followRepository.findFollowersByUserId(userId);
        return ResponseEntity.ok(followers);
    }

    @GetMapping("/following/{userId}")
    public ResponseEntity<List<User>> getFollowing(@PathVariable Long userId) {
        List<User> following = followRepository.findFollowingByUserId(userId);
        return ResponseEntity.ok(following);
    }
}
*/
