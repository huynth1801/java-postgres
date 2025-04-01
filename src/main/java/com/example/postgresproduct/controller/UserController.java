package com.example.postgresproduct.controller;


import com.example.postgresproduct.entity.User;
import com.example.postgresproduct.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController( final UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
