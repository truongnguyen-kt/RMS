package com.blues.iamservice.service.impl;

import com.blues.iamservice.model.Role;
import com.blues.iamservice.model.User;
import com.blues.iamservice.model.UserRole;
import com.blues.iamservice.repo.UserRoleRepo;
import com.blues.iamservice.service.UserRoleService;
import com.blues.iamservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;

    @Override
    public Optional<UserRole> findByUser_UsernameAndRole_Name(String username, String roleName) {
        return userRoleRepo.findByUser_UsernameAndRole_Name(username, roleName);
    }

    @Override
    public Optional<UserRole> findById(UUID id) {
        return userRoleRepo.findById(id);
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepo.save(userRole);
    }

    @Override
    public UserRole createUserRole(User user, Role role) {
        return saveUserRole(new UserRole(user, role));
    }
}
