package com.example.netify.web.controller;

import com.example.netify.domain.user.User;
import com.example.netify.service.AuthService;
import com.example.netify.service.UserService;
import com.example.netify.web.dto.auth.UserLoginRequest;
import com.example.netify.web.dto.user.UserDto;
import com.example.netify.web.dto.validation.OnCreate;
import com.example.netify.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/login")
    public String login(@Validated @RequestBody UserLoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

}
