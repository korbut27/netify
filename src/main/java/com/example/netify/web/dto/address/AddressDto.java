package com.example.netify.web.dto.address;

import com.example.netify.domain.user.User;
import com.example.netify.web.dto.validation.OnCreate;
import com.example.netify.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddressDto {

    @NotNull
    private Long addressId;

    @NotNull
    private User user;

    @NotNull(message = "City must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "City length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String city;

    @NotNull(message = "Street must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Street length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String street;

    @NotNull(message = "Home must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Home length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String home;

    @NotNull(message = "Flat must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private int flat;

}
