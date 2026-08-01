package com.ratelimit.DistributedRateLimiter.auth_service.auth_entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subscription_plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    // Rate Limits

    @Column(nullable = false)
    private Integer requestsPerMinute;

    @Column(nullable = false)
    private Integer requestsPerHour;

    @Column(nullable = false)
    private Integer requestsPerDay;

    @Column(nullable = false)
    private Integer burstCapacity;

    @Column(nullable = false)
    private Boolean active;
}
