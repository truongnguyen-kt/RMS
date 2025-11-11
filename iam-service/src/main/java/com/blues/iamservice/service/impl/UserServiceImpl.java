package com.blues.iamservice.service.impl;

import com.blues.common.env.dto.FileUploadResponse;
import com.blues.iamservice.config.exception.BadRequestException;
import com.blues.iamservice.config.minio.MinioConfig;
import com.blues.iamservice.mapper.UserMapper;
import com.blues.iamservice.model.Role;
import com.blues.iamservice.model.User;
import com.blues.iamservice.model.UserRole;
import com.blues.iamservice.repo.UserRepo;
import com.blues.iamservice.request.user.UserCreateRequest;
import com.blues.iamservice.response.user.UserResponse;
import com.blues.iamservice.service.FileRestClient;
import com.blues.iamservice.service.RoleService;
import com.blues.iamservice.service.UserRoleService;
import com.blues.iamservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final FileRestClient fileRestClient;
    private final MinioConfig minioConfig;
    private final RoleService roleService;
    private final UserRoleService userRoleService;

    @Transactional
    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
        User user = userMapper.toEntity(userCreateRequest);

        Optional<User> findByEmail = this.findByEmail(userCreateRequest.getEmail());
        if (findByEmail.isPresent()) {
            throw new BadRequestException("message.validation.user.email.duplicated");
        }

        Optional<User> findByUsername = this.findByUsername(userCreateRequest.getUsername());
        if (findByUsername.isPresent()) {
            throw new BadRequestException("message.validation.user.username.duplicated");
        }

        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));

        User savedUser = this.save(user);

        List<String> roles = userCreateRequest.getRoles();
        if (roles == null || roles.isEmpty()) {
            throw new BadRequestException("message.validation.user.role.null");
        }

        roles.forEach(role -> {
            Role roleEntity = this.roleService.findByName(role)
                    .orElseThrow(() -> new BadRequestException("message.filter.roles.not_found"));
            if (userRoleService.findByUser_UsernameAndRole_Name(userCreateRequest.getUsername(), roleEntity.getName()).isPresent()) {
                throw new BadRequestException("message.validation.user.role.duplicated");
            } else {
                UserRole ur = userRoleService.createUserRole(savedUser, roleEntity);
            }
        });

        return userMapper.toResponse(savedUser);
    }

    @Override
    public FileUploadResponse uploadAvatar(MultipartFile file) {
        try {
            FileUploadResponse response = fileRestClient.uploadFile(file, minioConfig.getBucketName(), minioConfig.getSubPath().getAvatar(), minioConfig.getAllowedExtension().getAvatar());
            String path = fileRestClient.getPresignedUrl(minioConfig.getBucketName(), response.getFileId());
            System.out.println(path);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Error while uploading avatar", e);
        }
    }

    @Override
    public UserResponse getUserById(UUID userId) {
        Optional<User> findById = this.findById(userId);
        if (findById.isEmpty()) {
            throw new BadRequestException("message.filter.users.not_found");
        }
        return userMapper.toResponse(findById.get());
    }

    @Transactional
    protected User save(User user) {
        return userRepo.save(user);
    }

    private Optional<User> findById(UUID id) {
        return this.userRepo.findById(id);
    }

    private Optional<User> findByUsername(String username) {
        return this.userRepo.findByUsername(username);
    }

    private Optional<User> findByEmail(String email) {
        return this.userRepo.findByEmail(email);
    }
}
