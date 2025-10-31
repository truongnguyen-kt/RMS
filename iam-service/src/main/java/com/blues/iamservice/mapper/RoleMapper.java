package com.blues.iamservice.mapper;

import com.blues.iamservice.model.Role;
import com.blues.iamservice.request.RoleCreateRequest;
import com.blues.iamservice.response.RoleResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role toEntity(RoleCreateRequest request) {
        String name = StringUtils.isNotBlank(request.getName()) ? request.getName() : "";
        String description = StringUtils.isNotBlank(request.getDescription()) ? request.getDescription() : "";
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        return role;
    }

    public RoleResponse toResponse(Role role) {
        return RoleResponse
                .builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .isDeleted(role.getIsDeleted())
                .isEnable(role.getIsEnable())
                .build();
    }
}
