package com.patient.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}