package com.ratelimit.DistributedRateLimiter.auth_service.auth_repositories;

import com.ratelimit.DistributedRateLimiter.auth_service.auth_entities.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
    Optional<SubscriptionPlan> findByName(String name);
}
