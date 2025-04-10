package com.example.postgresproduct.dto.response;

import com.example.postgresproduct.dto.request.RoleRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
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
    Set<RoleResponse> roles;
}
