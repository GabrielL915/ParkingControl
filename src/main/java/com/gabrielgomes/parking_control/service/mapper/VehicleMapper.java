package com.gabrielgomes.parking_control.service.mapper;

import com.gabrielgomes.parking_control.domain.Vehicle;
import com.gabrielgomes.parking_control.domain.dto.VehicleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleMapper implements ParkingControlMapper<Vehicle, VehicleDTO> {

    private final OwnerMapper ownerMapper;

    @Override
    public VehicleDTO toDTO(Vehicle vehicle) {
        return VehicleDTO.builder()
                .id(vehicle.getId())
                .licensePlate(vehicle.getLicensePlate())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .color(vehicle.getColor())
                .ownerDTO(ownerMapper.toDTO(vehicle.getOwner()))
                .build();
    }

    @Override
    public Vehicle toEntity(VehicleDTO vehicleDTO) {
        return Vehicle.builder()
                .licensePlate(vehicleDTO.getLicensePlate())
                .brand(vehicleDTO.getBrand())
                .model(vehicleDTO.getModel())
                .color(vehicleDTO.getColor())
                .owner(ownerMapper.toEntity(vehicleDTO.getOwnerDTO()))
                .build();
    }
}
