package com.kishanknows.backend.auth.dto;

public record UserRegistrationRequest(
        String name,
        String email,
        String username,
        String password
) {
}
