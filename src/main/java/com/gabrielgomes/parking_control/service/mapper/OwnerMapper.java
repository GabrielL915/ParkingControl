package com.gabrielgomes.parking_control.service.mapper;

import com.gabrielgomes.parking_control.domain.Owner;
import com.gabrielgomes.parking_control.domain.dto.OwnerDTO;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements ParkingControlMapper<Owner, OwnerDTO> {

    @Override
    public OwnerDTO toDTO(Owner owner) {
        return OwnerDTO.builder()
                .id(owner.getId())
                .name(owner.getName())
                .document(owner.getDocument())
                .build();
    }

    @Override
    public Owner toEntity(OwnerDTO ownerDTO) {
        return new Owner(ownerDTO.getName(), ownerDTO.getDocument());
    }
}
