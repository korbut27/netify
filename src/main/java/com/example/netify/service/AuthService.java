package com.example.netify.service;

import com.example.netify.web.dto.auth.UserLoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<String> login(UserLoginRequest loginRequest);

}
