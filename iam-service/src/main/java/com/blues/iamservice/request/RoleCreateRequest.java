package com.blues.iamservice.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleCreateRequest {

    @NotBlank(message = "message.validation.roles.name.blank")
    private String name;

    private String description;
}
