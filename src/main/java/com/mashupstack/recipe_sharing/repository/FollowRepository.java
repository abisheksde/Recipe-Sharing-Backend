/*
package com.mashupstack.recipe_sharing.repository;

import com.mashupstack.recipe_sharing.models.Follow;
import com.mashupstack.recipe_sharing.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO follows (follower_id, followee_id) VALUES (:followerId, :followeeId)")
    void followUser(@Param("followerId") Long followerId, @Param("followeeId") Long followeeId);

    @Modifying
    @Transactional
    @Query("DELETE FROM follows WHERE follower_id = :followerId AND followee_id = :followeeId")
    void unfollowUser(@Param("followerId") Long followerId, @Param("followeeId") Long followeeId);

    @Query("SELECT u FROM User u WHERE u.id IN (SELECT f.followerId FROM follows f WHERE f.followeeId = :userId)")
    List<User> findFollowersByUserId(@Param("userId") Long userId);

    @Query("SELECT u FROM User u WHERE u.id IN (SELECT f.followeeId FROM follows f WHERE f.followerId = :userId)")
    List<User> findFollowingByUserId(@Param("userId") Long userId);
}*/
