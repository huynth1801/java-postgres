package com.example.postgresproduct.service;

import com.example.postgresproduct.dto.request.PermissionRequest;
import com.example.postgresproduct.dto.request.RoleRequest;
import com.example.postgresproduct.dto.response.PermissionResponse;
import com.example.postgresproduct.dto.response.RoleResponse;
import com.example.postgresproduct.entity.Permission;
import com.example.postgresproduct.entity.Role;
import com.example.postgresproduct.repository.PermissionRepository;
import com.example.postgresproduct.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request) {
        // Tạo một thực thể Role mới từ RoleRequest
        Role role = new Role();
        role.setName(request.getName());
        role.setDescription(request.getDescription());

        // Lấy danh sách Permission từ repository bằng danh sách tên quyền
        Set<Permission> permissions = request.getPermissions().stream()
                .map(permissionRepository::findByName) // Giả sử có phương thức findByName
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        role.setPermissions(permissions);

        // Lưu thực thể Role vào database
        Role savedRole = roleRepository.save(role);

        // Tạo đối tượng RoleResponse từ Role đã lưu
        return new RoleResponse(
                savedRole.getName(),
                savedRole.getDescription(),
                savedRole.getPermissions().stream()
                        .map(Permission::getName)
                        .collect(Collectors.toSet())
        );
    }

}
