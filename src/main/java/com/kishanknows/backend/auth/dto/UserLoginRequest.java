package com.kishanknows.backend.auth.dto;

public record UserLoginRequest(
        String username,
        String password
) {
}
