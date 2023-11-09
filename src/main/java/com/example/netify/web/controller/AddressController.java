package com.example.netify.web.controller;

import com.example.netify.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
@Validated
public class AddressController {

    private final AddressService addressService;

}
