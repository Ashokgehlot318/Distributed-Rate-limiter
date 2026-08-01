package com.ratelimit.DistributedRateLimiter.auth_service.auth_repositories;

import com.ratelimit.DistributedRateLimiter.auth_service.auth_entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

}
