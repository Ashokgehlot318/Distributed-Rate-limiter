package com.ratelimit.DistributedRateLimiter.auth_service.auth_dto;



public record LoginRequest(
        String email,
        String password) {
}
