package com.blues.iamservice.repo.impl;

import com.blues.iamservice.model.User;
import com.blues.iamservice.repo.UserRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepoImpl extends UserRepo, JpaRepository<User, UUID> {
}
