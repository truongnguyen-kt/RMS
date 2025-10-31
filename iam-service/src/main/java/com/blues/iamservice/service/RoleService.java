package com.blues.iamservice.service;

import com.blues.iamservice.model.Role;
import com.blues.iamservice.request.RoleCreateRequest;
import com.blues.iamservice.request.RoleFilterRequest;
import com.blues.iamservice.response.RoleResponse;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    RoleResponse createRole(RoleCreateRequest roleCreateRequest);

    Role save(Role role);

    Optional<Role> findById(UUID id);

    Optional<Role> findByName(String name);

    RoleResponse getRoleById(String id);

    Page<RoleResponse> filterRole(RoleFilterRequest request);
}
