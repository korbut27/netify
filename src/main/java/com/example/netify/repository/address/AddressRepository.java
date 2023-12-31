package com.example.netify.repository.address;

import com.example.netify.domain.address.Address;
import com.example.netify.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> getAddressByAddressId(Long id);

    Optional<Address> getAddressByUser(User user);
}
