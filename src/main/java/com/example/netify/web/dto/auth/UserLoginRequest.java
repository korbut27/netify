package com.example.netify.web.dto.auth;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String login;
    private String password;
}
