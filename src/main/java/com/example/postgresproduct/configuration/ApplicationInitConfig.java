package com.example.postgresproduct.configuration;

import com.example.postgresproduct.entity.ERole;
import com.example.postgresproduct.entity.Role;
import com.example.postgresproduct.repository.RoleRepository;
import com.example.postgresproduct.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            // Ensure the ADMIN role exists in the database
            Optional<Role> adminRoleOptional = roleRepository.findByName(ERole.valueOf(ERole.ADMIN.name()));
            Role adminRole = adminRoleOptional.orElseGet(() -> {
                Role newRole = new Role();
                log.info(String.valueOf(ERole.valueOf(ERole.ADMIN.name())));
                newRole.setName(ERole.valueOf(ERole.ADMIN.name()));
                return roleRepository.save(newRole);
            });

            log.info("Admin role: {}", adminRole);
            log.info("Role name {}", adminRole.getName());

            // Check if the admin user already exists
            if (userRepository.findByUsername("admin").isEmpty()) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setRoles(Set.of(adminRole)); // Set the ADMIN role
                userRepository.save(user);
                log.warn("Admin user has been created with default password: admin. Please change it.");
            }
        };
    }
}
