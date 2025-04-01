package com.example.postgresproduct.dto.response;

import com.example.postgresproduct.dto.request.RoleRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstname;
    String lastname;
    String email;
    LocalDate dob;
    Set<RoleRequest> roles;
}
