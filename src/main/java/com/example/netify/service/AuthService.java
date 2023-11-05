package com.example.netify.service;

import com.example.netify.web.dto.auth.UserLoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<String> login(UserLoginRequest loginRequest);

}
