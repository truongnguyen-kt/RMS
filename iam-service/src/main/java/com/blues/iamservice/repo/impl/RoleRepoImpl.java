package com.blues.iamservice.repo.impl;

import com.blues.iamservice.model.Role;
import com.blues.iamservice.repo.RoleRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepoImpl extends RoleRepo, JpaRepository<Role, UUID> {
}
