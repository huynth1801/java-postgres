package com.example.postgresproduct.repository;

import com.example.postgresproduct.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
