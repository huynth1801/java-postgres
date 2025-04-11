package com.example.postgresproduct.service;


import com.example.postgresproduct.dto.request.UserCreationRequest;
import com.example.postgresproduct.entity.ERole;
import com.example.postgresproduct.entity.Role;
import com.example.postgresproduct.entity.User;
import com.example.postgresproduct.exception.AppException;
import com.example.postgresproduct.exception.ErrorCode;
import com.example.postgresproduct.mapper.UserMapper;
import com.example.postgresproduct.repository.RoleRepository;
import com.example.postgresproduct.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.postgresproduct.dto.response.UserResponse;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;
    RoleRepository roleRepository;

    public UserResponse createUser(UserCreationRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Set<String> roles = new HashSet<>();
        roles.add(ERole.USER.name());
        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
    }
}
