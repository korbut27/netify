package com.example.netify.service.impl;

import com.example.netify.domain.address.Address;
import com.example.netify.domain.exception.ResourceNotFoundException;
import com.example.netify.domain.user.User;
import com.example.netify.repository.address.AddressRepository;
import com.example.netify.repository.user.UserRepository;
import com.example.netify.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private  final UserRepository userRepository;

    @Override
    public Address getById(Long id) {
        return addressRepository.getAddressByAddressId(id)
                .orElseThrow(()-> new ResourceNotFoundException("Address not found."));
    }

    @Override
    public Address getByUser(User user) {
        return addressRepository.getAddressByUser(user)
                .orElseThrow(()-> new ResourceNotFoundException("Address not found."));
    }

    @Override
    public Address update(Address address) {
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address create(Address address, Long userId) {
        if(!userRepository.existsById(userId)){
            throw new ResourceNotFoundException("User not found.");
        }
        address.setUser(userRepository.getById(userId));
        addressRepository.save(address);
        return address;
    }

    @Override
    public void delete(Long id) {
        if(!addressRepository.existsById(id)){
            throw new ResourceNotFoundException("Address not found.");
        }
        addressRepository.deleteById(id);
    }
}
