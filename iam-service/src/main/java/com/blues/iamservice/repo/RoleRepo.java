package com.blues.iamservice.repo;

import com.blues.iamservice.model.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepo {
    Role save(Role role);

    Optional<Role> findById(UUID id);

    Optional<Role> findByName(String name);
}
