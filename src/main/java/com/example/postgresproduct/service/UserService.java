package com.example.postgresproduct.service;


import com.example.postgresproduct.dto.request.UserCreationRequest;
import com.example.postgresproduct.entity.User;
import com.example.postgresproduct.exception.AppException;
import com.example.postgresproduct.exception.ErrorCode;
import com.example.postgresproduct.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        // Check if email was existed
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User newUser = User.builder()
                .username(request.getUsername())
                .build();

        // Lưu vào database
        User savedUser = userRepository.save(newUser);
        return savedUser;
    }
}
