package com.example.netify.web.mappers;

import com.example.netify.domain.user.User;
import com.example.netify.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
