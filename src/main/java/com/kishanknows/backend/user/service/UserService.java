package com.kishanknows.backend.user.service;

import com.kishanknows.backend.user.dto.UserRequest;
import com.kishanknows.backend.user.mapper.UserMapper;
import com.kishanknows.backend.user.model.User;
import com.kishanknows.backend.user.model.UserEntity;
import com.kishanknows.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public List<User> getUsers() {
        return repo.findAll()
                .stream()
                .map(UserMapper::toDomain)
                .toList();
    }

    public User createUser(UserRequest request){
        UserEntity entity = UserMapper.toEntity(request);
        UserEntity saved = repo.save(entity);
        return UserMapper.toDomain(saved);
    }
}
