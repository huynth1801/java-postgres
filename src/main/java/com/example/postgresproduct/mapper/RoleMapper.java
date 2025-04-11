package com.example.postgresproduct.mapper;

import com.example.postgresproduct.dto.request.RoleRequest;
import com.example.postgresproduct.dto.response.RoleResponse;
import com.example.postgresproduct.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
