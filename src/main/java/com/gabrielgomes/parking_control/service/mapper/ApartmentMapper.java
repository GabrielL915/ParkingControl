package com.gabrielgomes.parking_control.service.mapper;

import com.gabrielgomes.parking_control.domain.Apartment;
import com.gabrielgomes.parking_control.domain.dto.ApartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApartmentMapper implements ParkingControlMapper<Apartment, ApartmentDTO> {

    private final OwnerMapper ownerMapper;

    @Override
    public ApartmentDTO toDTO(Apartment apartment) {
        return ApartmentDTO.builder()
                .id(apartment.getId())
                .number(apartment.getNumber())
                .ownerDTO(ownerMapper.toDTO(apartment.getOwner()))
                .build();
    }

    @Override
    public Apartment toEntity(ApartmentDTO apartmentDTO) {
        return Apartment.builder()
                .number(apartmentDTO.getNumber())
                .owner(ownerMapper.toEntity(apartmentDTO.getOwnerDTO()))
                .build();
    }
}
