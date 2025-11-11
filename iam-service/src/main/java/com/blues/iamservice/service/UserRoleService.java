package com.blues.iamservice.service;

import com.blues.iamservice.model.Role;
import com.blues.iamservice.model.User;
import com.blues.iamservice.model.UserRole;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleService {
    Optional<UserRole> findByUser_UsernameAndRole_Name(String username, String roleName);

    Optional<UserRole> findById(UUID id);

    UserRole saveUserRole(UserRole userRole);

    UserRole createUserRole(User user, Role role);
}
