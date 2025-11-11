package com.blues.iamservice.response.user;

import com.blues.iamservice.enums.GenderEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserResponse {
    private UUID id;

    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private LocalDateTime lastSignIn;

    private String phone;

    private Date birthday;

    private GenderEnum gender;

    private String avatar;

    private Boolean isEnable;

    private Boolean isDeleted;

    private Integer loginFailedNum;
}
