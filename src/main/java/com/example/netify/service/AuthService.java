package com.example.netify.service;

import com.example.netify.web.dto.auth.JwtRequest;
import com.example.netify.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
