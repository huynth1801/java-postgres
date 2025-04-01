package com.example.postgresproduct.repository;

import com.example.postgresproduct.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    Optional<Permission> findByName(String name);
}
