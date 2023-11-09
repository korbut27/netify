package com.example.netify.service;

import com.example.netify.domain.address.Address;
import com.example.netify.domain.user.User;

public interface AddressService {
    Address getById(Long id);
    Address getByUser(User user);
    Address update(Address address);
    Address create(Address address, Long userId);
    void delete(Long id);
}
