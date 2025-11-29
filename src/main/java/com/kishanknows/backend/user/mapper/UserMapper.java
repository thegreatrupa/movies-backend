package com.kishanknows.backend.user.mapper;

import com.kishanknows.backend.user.dto.*;
import com.kishanknows.backend.user.model.*;

public class UserMapper {
    public static UserEntity toEntity(User user){
        return new UserEntity(null, user.name(), user.email(), user.username(), user.password());
    }

    public static User toDomain(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword()
        );
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(user.id(), user.name(), user.email());
    }
}
