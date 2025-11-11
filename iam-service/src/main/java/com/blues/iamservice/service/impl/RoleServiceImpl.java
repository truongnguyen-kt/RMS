package com.blues.iamservice.service.impl;

import com.blues.common.env.utils.PageUtil;
import com.blues.iamservice.config.exception.BadRequestException;
import com.blues.iamservice.config.exception.InternalServerErrorException;
import com.blues.iamservice.config.exception.NotFoundException;
import com.blues.iamservice.mapper.RoleMapper;
import com.blues.iamservice.model.Role;
import com.blues.iamservice.repo.RoleRepo;
import com.blues.iamservice.request.RoleCreateRequest;
import com.blues.iamservice.request.RoleFilterRequest;
import com.blues.iamservice.response.RoleResponse;
import com.blues.iamservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    private final RoleMapper roleMapper;

    @Override
    @Transactional
    public RoleResponse createRole(RoleCreateRequest roleCreateRequest) {
        String roleName = roleCreateRequest.getName();

        // validate if role name is contained in DB
        Optional<Role> searchRole = findByName(roleName);
        if (searchRole.isPresent()) {
            throw new BadRequestException("message.validation.role.duplicate");
        }

        Role role = roleMapper.toEntity(roleCreateRequest);
        try {
            Role savedRole = this.save(role);
            return roleMapper.toResponse(savedRole);
        } catch (Exception e) {
            log.error("{}: {}", RoleServiceImpl.class.getName(), e.getMessage(), e);
            throw new InternalServerErrorException("message.error.server.exception");
        }
    }

    @Transactional
    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public RoleResponse getRoleById(String id) {
        Optional<Role> foundRole = this.findById(UUID.fromString(id));
        return foundRole.map(roleMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("message.filter.roles.not_found"));
    }

    @Override
    public Page<RoleResponse> filterRole(RoleFilterRequest request) {
        Pageable pageable = PageUtil.getPageable(request);
        String keywords = StringUtils.isBlank(request.getKeywords()) ? "" : request.getKeywords();
        return roleRepo.findByNameContaining(keywords, pageable).map(roleMapper::toResponse);
    }

    @Override
    public Optional<Role> findById(UUID id) {
        return roleRepo.findById(id);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepo.findByName(name);
    }
}
