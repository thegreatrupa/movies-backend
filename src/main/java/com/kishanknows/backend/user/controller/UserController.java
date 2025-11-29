package com.kishanknows.backend.user.controller;

import com.kishanknows.backend.user.dto.UserRequest;
import com.kishanknows.backend.user.dto.UserResponse;
import com.kishanknows.backend.user.mapper.UserMapper;
import com.kishanknows.backend.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        return service.getUsers()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
