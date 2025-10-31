package com.blues.iamservice.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleCreateRequest {

    @NotBlank(message = "message.validation.roles.name.blank")
    @Size(max = 250, message = "message.validation.roles.name.size")
    private String name;

    private String description;
}
