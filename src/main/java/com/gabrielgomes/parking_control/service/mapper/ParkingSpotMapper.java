package com.gabrielgomes.parking_control.service.mapper;

import com.gabrielgomes.parking_control.domain.ParkingSpot;
import com.gabrielgomes.parking_control.domain.dto.ParkingSpotDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParkingSpotMapper implements ParkingControlMapper<ParkingSpot, ParkingSpotDTO> {

    private final ApartmentMapper apartmentMapper;

    @Override
    public ParkingSpotDTO toDTO(ParkingSpot parkingSpot) {
        return ParkingSpotDTO.builder()
                .id(parkingSpot.getId())
                .number(parkingSpot.getNumber())
                .apartmentDTO(apartmentMapper.toDTO(parkingSpot.getApartment()))
                .build();
    }

    @Override
    public ParkingSpot toEntity(ParkingSpotDTO parkingSpotDTO) {
        return ParkingSpot.builder()
                .number(parkingSpotDTO.getNumber())
                .apartment(apartmentMapper.toEntity(parkingSpotDTO.getApartmentDTO()))
                .build();
    }
}
