package com.example.postgresproduct.repository;

import com.example.postgresproduct.entity.ERole;
import com.example.postgresproduct.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
