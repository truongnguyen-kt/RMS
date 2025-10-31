package com.blues.iamservice.controller;

import com.blues.iamservice.request.RoleCreateRequest;
import com.blues.iamservice.request.RoleFilterRequest;
import com.blues.iamservice.response.RoleResponse;
import com.blues.iamservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    ResponseEntity<?> createRole(@RequestBody RoleCreateRequest roleCreateRequest) {
        RoleResponse savedRole = roleService.createRole(roleCreateRequest);
        URI location = URI.create("/roles/" + savedRole.getId());
        return ResponseEntity.created(location).body(savedRole);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getRole(@PathVariable String id) {
        RoleResponse gotRole = roleService.getRoleById(id);
        return ResponseEntity.ok(gotRole);
    }

    @PostMapping("/filter")
    ResponseEntity<?> filterRole(@RequestBody RoleFilterRequest request) {
        Page<RoleResponse> result = roleService.filterRole(request);
        return ResponseEntity.ok(result);
    }
}
