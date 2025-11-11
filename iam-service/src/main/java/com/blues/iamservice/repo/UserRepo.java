package com.blues.iamservice.repo;

import com.blues.iamservice.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID id);

    User save(User user);
}
