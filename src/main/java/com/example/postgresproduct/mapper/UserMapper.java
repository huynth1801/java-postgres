package com.example.postgresproduct.mapper;

import com.example.postgresproduct.dto.request.UserCreationRequest;
import com.example.postgresproduct.dto.response.UserResponse;
import com.example.postgresproduct.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

//    @Mapping(target = "roles", ignore = true)
//    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
