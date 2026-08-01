package com.ratelimit.DistributedRateLimiter.auth_service.auth_controllers;


import com.ratelimit.DistributedRateLimiter.auth_service.auth_dto.LoginRequest;
import com.ratelimit.DistributedRateLimiter.auth_service.auth_utills.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthenticationManager authenticationManager;

    JwtUtils jwtUtils;

    public AuthController(JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest){
        try{
            IO.println("Authenticating....");
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
            IO.println("Authentication done....");
        }
        catch (Exception e){
            IO.println(e.getMessage());
            IO.println(e.getStackTrace());
            e.printStackTrace();
            throw e;
        }

        return jwtUtils.genearteToken(loginRequest.email());

    }
}
