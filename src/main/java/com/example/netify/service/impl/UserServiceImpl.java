package com.example.netify.service.impl;

import com.example.netify.domain.exception.ResourceNotFoundException;
import com.example.netify.domain.user.Role;
import com.example.netify.domain.user.User;
import com.example.netify.repository.user.UserRepository;
import com.example.netify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));

    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found."));
    }

    @Override
    public User update(User newUser) {
        return userRepository.findById(newUser.getUserId())
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    return userRepository.save(user);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    @Override
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User already exists.");
        }
        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            throw new IllegalStateException(
                    "Password and password confirmation do not match."
            );
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = Set.of(Role.ROLE_USER);
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("User not found.");
        }
        userRepository.deleteById(id);
    }
}
