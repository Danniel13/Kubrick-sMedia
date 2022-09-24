package com.dani.dev.videotienda.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dani.dev.videotienda.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    Optional<User> findByUsernameAndPasswordAndActiveIsTrue(String username, String password);

    Optional<User> findByEmail(String email);
}
