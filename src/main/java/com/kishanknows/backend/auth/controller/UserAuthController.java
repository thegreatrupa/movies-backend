package com.kishanknows.backend.auth.controller;

import com.kishanknows.backend.auth.dto.UserAuthResponse;
import com.kishanknows.backend.auth.dto.UserLoginRequest;
import com.kishanknows.backend.auth.dto.UserRegistrationRequest;
import com.kishanknows.backend.auth.mapper.UserAuthMapper;
import com.kishanknows.backend.auth.service.UserAuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    private final UserAuthService service;

    public UserAuthController(UserAuthService service){
        this.service = service;
    }

    @PostMapping("/register")
    public UserAuthResponse registerUser(@RequestBody UserRegistrationRequest request){
        return UserAuthMapper
                .toResponse(service.registerUser(request));
    }

    @PostMapping("/login")
    public UserAuthResponse loginUser(@RequestBody UserLoginRequest request){
        return UserAuthMapper
                .toResponse(service.loginUser(request));
    }
}
