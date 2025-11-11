package com.blues.iamservice.repo.impl;

import com.blues.iamservice.model.UserRole;
import com.blues.iamservice.repo.UserRoleRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepoImpl extends UserRoleRepo, JpaRepository<UserRole, UUID> {
    Optional<UserRole> findByUser_UsernameAndRole_Name(String user_username, String role_name);
}
