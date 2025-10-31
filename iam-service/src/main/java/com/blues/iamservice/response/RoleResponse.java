package com.blues.iamservice.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class RoleResponse {
    private UUID id;

    private String name;

    private String description;

    private Boolean isEnable;

    private Boolean isDeleted;
}
