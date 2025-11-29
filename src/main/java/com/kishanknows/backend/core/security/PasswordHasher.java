package com.kishanknows.backend.core.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String hash(String rawPassword){
        return encoder.encode(rawPassword);
    }

    public Boolean matches(String rawPassword, String hashedPassword){
        return encoder.matches(rawPassword, hashedPassword);
    }
}
