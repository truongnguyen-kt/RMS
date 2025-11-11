package com.blues.iamservice.mapper;

import com.blues.iamservice.model.User;
import com.blues.iamservice.request.user.UserCreateRequest;
import com.blues.iamservice.response.user.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .lastSignIn(user.getLastSignIn())
                .phone(user.getPhone())
                .birthday(user.getBirthday())
                .gender(user.getGender())
                .avatar(user.getAvatar())
                .isEnable(user.getIsEnable())
                .isDeleted(user.getIsDeleted())
                .loginFailedNum(user.getLoginFailedNum())
                .build();
    }

    public User toEntity(UserCreateRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhone(userRequest.getPhone());
        user.setBirthday(userRequest.getBirthday());
        user.setGender(userRequest.getGender());
        user.setAvatar(userRequest.getAvatar());

        user.setIsDeleted(Boolean.FALSE);
        user.setLoginFailedNum(0);
        user.setIsEnable(Boolean.TRUE);
        user.setLastSignIn(LocalDateTime.now());
        return user;
    }
}
