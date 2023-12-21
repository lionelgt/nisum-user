package com.nisum.user.api.controller;

import com.nisum.user.api.dto.UserRequest;
import com.nisum.user.api.dto.UserResponse;
import com.nisum.user.api.mapper.UserMapper;
import com.nisum.user.domain.model.User;
import com.nisum.user.domain.use_case.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    
    private final UserService userService;

    @GetMapping
    public List<UserResponse> index(){
        return userService.findAll().stream()
                             .map(userMapper::map)
                             .toList();
    }
    
    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest) {
        User userToSave = userMapper.map(userRequest);
        return  userMapper.map(userService.create(userToSave));
    }
}
