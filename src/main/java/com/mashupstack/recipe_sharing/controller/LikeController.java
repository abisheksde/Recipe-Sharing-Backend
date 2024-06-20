/*
package com.mashupstack.recipe_sharing.controller;

import com.mashupstack.recipe_sharing.dto.LikeRequest;
import com.mashupstack.recipe_sharing.models.Like;
import com.mashupstack.recipe_sharing.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeRepository likeRepository;

    @PostMapping("/like")
    public ResponseEntity<?> likePost(@RequestBody LikeRequest likeRequest) {

        if (!likeRepository.findByPostIdAndUsername(likeRequest.getPostId(), likeRequest.getUsername()).isPresent()) {
            Like like = new Like();
            like.setPostId(likeRequest.getPostId());
            like.setUsername(likeRequest.getUsername());
            likeRepository.save(like);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlikePost(@RequestBody LikeRequest likeRequest) {
        likeRepository.findByPostIdAndUsername(likeRequest.getPostId(), likeRequest.getUsername()).ifPresent(likeRepository::delete);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count/{postId}")
    public ResponseEntity<Long> getLikeCount(@PathVariable Long postId) {
        return ResponseEntity.ok(likeRepository.countByPostId(postId));
    }
}

*/
