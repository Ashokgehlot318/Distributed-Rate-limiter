package com.ratelimit.DistributedRateLimiter.auth_service.auth_utills;


import com.ratelimit.DistributedRateLimiter.auth_service.auth_entities.AccountStatus;
import com.ratelimit.DistributedRateLimiter.auth_service.auth_entities.SubscriptionPlan;
import com.ratelimit.DistributedRateLimiter.auth_service.auth_entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
public class CustomUserPrincipal implements UserDetails {
    private final UUID id;

    private final String username;

    private final String email;

    private final String password;

    private final String role;

    private final SubscriptionPlan subscriptionPlan;

    private AccountStatus accountStatus;

    public CustomUserPrincipal(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole().name();
        this.subscriptionPlan = user.getSubscriptionPlan();
        this.accountStatus = user.getAccountStatus();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountStatus != AccountStatus.BLOCKED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return accountStatus == AccountStatus.ACTIVE;
    }
}
