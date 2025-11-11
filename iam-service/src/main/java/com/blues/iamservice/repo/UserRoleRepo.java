package com.blues.iamservice.repo;

import com.blues.iamservice.model.UserRole;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepo {
    UserRole save(UserRole userRole);

    Optional<UserRole> findById(UUID id);

    Optional<UserRole> findByUser_UsernameAndRole_Name(String username, String roleName);
}
