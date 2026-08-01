package com.ratelimit.DistributedRateLimiter.auth_service;

import com.ratelimit.DistributedRateLimiter.auth_service.auth_entities.*;
import com.ratelimit.DistributedRateLimiter.auth_service.auth_repositories.SubscriptionPlanRepository;
import com.ratelimit.DistributedRateLimiter.auth_service.auth_repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class User_DataInitializer implements CommandLineRunner {

    private final SubscriptionPlanRepository subscriptionPlanRepository;
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (subscriptionPlanRepository.count() == 0) {

            SubscriptionPlan free = SubscriptionPlan.builder()
                    .name("FREE")
                    .description("Free Plan")
                    .requestsPerMinute(10)
                    .requestsPerHour(500)
                    .requestsPerDay(5000)
                    .burstCapacity(20)
                    .active(true)
                    .build();

            SubscriptionPlan premium = SubscriptionPlan.builder()
                    .name("PREMIUM")
                    .description("Premium Plan")
                    .requestsPerMinute(100)
                    .requestsPerHour(5000)
                    .requestsPerDay(50000)
                    .burstCapacity(150)
                    .active(true)
                    .build();

            SubscriptionPlan pro = SubscriptionPlan.builder()
                    .name("PRO")
                    .description("Pro Plan")
                    .requestsPerMinute(500)
                    .requestsPerHour(50000)
                    .requestsPerDay(500000)
                    .burstCapacity(700)
                    .active(true)
                    .build();

            SubscriptionPlan proMax = SubscriptionPlan.builder()
                    .name("PRO_MAX")
                    .description("Pro Max Plan")
                    .requestsPerMinute(2000)
                    .requestsPerHour(200000)
                    .requestsPerDay(2000000)
                    .burstCapacity(3000)
                    .active(true)
                    .build();

            subscriptionPlanRepository.save(free);
            subscriptionPlanRepository.save(premium);
            subscriptionPlanRepository.save(pro);
            subscriptionPlanRepository.save(proMax);
        }

        if (userRepository.count() == 0) {

            SubscriptionPlan free = subscriptionPlanRepository.findByName("FREE").get();
            SubscriptionPlan premium = subscriptionPlanRepository.findByName("PREMIUM").get();
            SubscriptionPlan pro = subscriptionPlanRepository.findByName("PRO").get();
            SubscriptionPlan proMax = subscriptionPlanRepository.findByName("PRO_MAX").get();

            userRepository.save(User.builder()
                    .username("ashok")
                    .email("ashok@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.ADMIN)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(proMax)
                    .build());

            userRepository.save(User.builder()
                    .username("john")
                    .email("john@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(free)
                    .build());

            userRepository.save(User.builder()
                    .username("alice")
                    .email("alice@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(premium)
                    .build());

            userRepository.save(User.builder()
                    .username("bob")
                    .email("bob@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(pro)
                    .build());

            userRepository.save(User.builder()
                    .username("charlie")
                    .email("charlie@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(free)
                    .build());

            userRepository.save(User.builder()
                    .username("david")
                    .email("david@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(premium)
                    .build());

            userRepository.save(User.builder()
                    .username("emma")
                    .email("emma@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(pro)
                    .build());

            userRepository.save(User.builder()
                    .username("frank")
                    .email("frank@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(proMax)
                    .build());

            userRepository.save(User.builder()
                    .username("grace")
                    .email("grace@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(free)
                    .build());

            userRepository.save(User.builder()
                    .username("harry")
                    .email("harry@gmail.com")
                    .password("password")
//                    .password(passwordEncoder.encode("password"))
                    .role(UserRole.USER)
                    .accountStatus(AccountStatus.ACTIVE)
                    .subscriptionPlan(pro)
                    .build());
        }
    }
}
