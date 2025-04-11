package com.example.postgresproduct.controller;


import com.example.postgresproduct.dto.request.ApiResponse;
import com.example.postgresproduct.dto.request.UserCreationRequest;
import com.example.postgresproduct.dto.response.UserResponse;
import com.example.postgresproduct.entity.User;
import com.example.postgresproduct.repository.UserRepository;
import com.example.postgresproduct.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }
//
//    @GetMapping
//    ApiResponse<List<UserResponse>> getUsers() {
//        return ApiResponse.<List<UserResponse>>builder()
//                .result(userService.getUsers())
//                .build();
//    }
//
//    @GetMapping("/{userId}")
//    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
//        return ApiResponse.<UserResponse>builder()
//                .result(userService.getUser(userId))
//                .build();
//    }
}
