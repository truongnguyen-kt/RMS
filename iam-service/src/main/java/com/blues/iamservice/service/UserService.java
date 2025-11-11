package com.blues.iamservice.service;

import com.blues.common.env.dto.FileUploadResponse;
import com.blues.iamservice.request.user.UserCreateRequest;
import com.blues.iamservice.response.user.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserCreateRequest userCreateRequest);

    FileUploadResponse uploadAvatar(MultipartFile file);

    UserResponse getUserById(UUID userId);
}
