package com.example.postgresproduct.service;

import com.example.postgresproduct.dto.request.PermissionRequest;
import com.example.postgresproduct.dto.request.RoleRequest;
import com.example.postgresproduct.dto.response.PermissionResponse;
import com.example.postgresproduct.dto.response.RoleResponse;
import com.example.postgresproduct.entity.Permission;
import com.example.postgresproduct.entity.Role;
import com.example.postgresproduct.mapper.RoleMapper;
import com.example.postgresproduct.repository.PermissionRepository;
import com.example.postgresproduct.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    @Autowired
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
