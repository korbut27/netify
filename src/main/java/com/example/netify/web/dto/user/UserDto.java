package com.example.netify.web.dto.user;

import com.example.netify.web.dto.validation.OnCreate;
import com.example.netify.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long userId;

    @NotNull(message = "Username must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null.", groups = {OnCreate.class})
    private String passwordConfirmation;

    @NotNull(message = "Firstname must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Firstname length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String firstName;

    @NotNull(message = "Surname must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Surname length must be smaller than 255 symbols.", groups = {OnUpdate.class, OnCreate.class})
    private String surname;

    @NotNull(message = "Pnonenumber must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "^\\+375(33|29|44)\\d{7}$", message = "Please provide a valid phonenumber")
    private String phoneNumber;

    @NotNull(message = "Email must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Email(message = "Please provide a valid email address.")
    private String email;

    private int balance;

}
