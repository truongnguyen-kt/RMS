package com.blues.iamservice.repo;

import com.blues.iamservice.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepo {
    Role save(Role role);

    Optional<Role> findById(UUID id);

    Optional<Role> findByName(String name);

    Page<Role> findByNameContaining(String name, Pageable pageable);
}
