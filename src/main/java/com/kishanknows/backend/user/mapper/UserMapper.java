package com.kishanknows.backend.user.mapper;

import com.kishanknows.backend.user.dto.*;
import com.kishanknows.backend.user.model.*;

public class UserMapper {
    public static UserEntity toEntity(UserRequest request){
        return new UserEntity(null, request.name(), request.email());
    }

    public static User toDomain(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail()
        );
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(user.id(), user.name(), user.email());
    }
}
