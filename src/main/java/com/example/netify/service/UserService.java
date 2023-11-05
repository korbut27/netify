package com.example.netify.service;

import com.example.netify.domain.user.User;


public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);
    void delete(Long id);
}
