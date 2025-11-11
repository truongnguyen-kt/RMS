package com.blues.iamservice.controller;

import com.blues.common.env.dto.FileUploadResponse;
import com.blues.iamservice.request.user.UserCreateRequest;
import com.blues.iamservice.response.user.UserResponse;
import com.blues.iamservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    ResponseEntity<?> createUser(@RequestBody UserCreateRequest userRequest){
        UserResponse savedUser = userService.createUser(userRequest);
        URI location = URI.create("/users/" + savedUser.getId());
        return ResponseEntity.created(location).body(savedUser);
    }

    @PostMapping("/upload-avatar")
    ResponseEntity<?> uploadAvatar(@RequestParam("file") MultipartFile file){
        FileUploadResponse fileResponse = userService.uploadAvatar(file);
        return ResponseEntity.ok(fileResponse);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUser(@PathVariable UUID id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
