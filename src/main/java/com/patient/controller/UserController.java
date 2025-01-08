package com.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.patient.dao.UserRepository;
import com.patient.entity.User;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "User Management APIs")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Registers a new user with email and password")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User registered successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input", 
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists.");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    @Operation(summary = "User login", description = "Logs in a user with email and password")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login successful"),
        @ApiResponse(responseCode = "400", description = "Invalid credentials", 
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<String> login(@RequestBody User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())
                .map(u -> ResponseEntity.ok("Login successful."))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials."));
    }
}
