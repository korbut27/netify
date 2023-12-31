package com.example.netify.web.controller;

import com.example.netify.domain.address.Address;
import com.example.netify.domain.user.User;
import com.example.netify.service.AddressService;
import com.example.netify.service.UserService;
import com.example.netify.web.dto.address.AddressDto;
import com.example.netify.web.dto.user.UserDto;
import com.example.netify.web.dto.validation.OnCreate;
import com.example.netify.web.dto.validation.OnUpdate;
import com.example.netify.web.mappers.AddressMapper;
import com.example.netify.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final AddressService addressService;

    private final UserMapper userMapper;
    private final AddressMapper addressMapper;



    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }

    @PostMapping("/{id}/address")
    public AddressDto createTask(@PathVariable Long id,
                                 @Validated(OnCreate.class)
                              @RequestBody AddressDto dto) {
        Address address = addressMapper.toEntity(dto);
        Address createdAddress = addressService.create(address, id);
        return addressMapper.toDto(createdAddress);
    }


}
