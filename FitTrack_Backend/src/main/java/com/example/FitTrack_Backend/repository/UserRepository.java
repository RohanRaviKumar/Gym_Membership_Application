package com.example.FitTrack_Backend.repository;

import com.example.FitTrack_Backend.entity.User;
import com.example.FitTrack_Backend.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    List<User> findByRole(Role role);      // get all trainers
}