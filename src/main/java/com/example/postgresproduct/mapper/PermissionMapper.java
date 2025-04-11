package com.example.postgresproduct.mapper;

import com.example.postgresproduct.dto.request.PermissionRequest;
import com.example.postgresproduct.dto.response.PermissionResponse;
import com.example.postgresproduct.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
