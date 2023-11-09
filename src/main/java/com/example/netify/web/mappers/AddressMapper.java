package com.example.netify.web.mappers;

import com.example.netify.domain.address.Address;
import com.example.netify.web.dto.address.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toDto(Address address);

    Address toEntity(AddressDto addressDto);
}
