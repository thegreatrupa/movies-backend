package com.kishanknows.backend.user.model;

import com.kishanknows.backend.user.Role;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

public record User(
        Long id,
        String name,
        String email,
        String username,
        String password


){}
