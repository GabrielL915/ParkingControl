package com.gabrielgomes.parking_control.service;

import com.gabrielgomes.parking_control.domain.Vehicle;
import com.gabrielgomes.parking_control.domain.dto.VehicleDTO;
import com.gabrielgomes.parking_control.domain.repository.VehicleRepository;
import com.gabrielgomes.parking_control.service.exception.EntityAlreadyExistsException;
import com.gabrielgomes.parking_control.service.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends CRUDService<Vehicle, Long, VehicleDTO> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    protected void updateData(Vehicle vehicle, VehicleDTO vehicleDTO) {
        checkBeforeSave(vehicleDTO, vehicle);
        vehicle.setLicensePlate(vehicleDTO.getLicensePlate());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setOwner(ownerMapper.toEntity(vehicleDTO.getOwnerDTO()));
    }

    @Override
    protected void checkBeforeSave(VehicleDTO vehicleDTO, Vehicle vehicle) {
        if (entityAlreadyExists(vehicleDTO, vehicle)) {
            throw new EntityAlreadyExistsException("A vehicle with this document already exists.");
        }
    }

    private boolean entityAlreadyExists(VehicleDTO vehicleDTO, Vehicle vehicle) {
        return vehicleRepository.findByLicensePlate(vehicleDTO.getLicensePlate())
                .stream()
                .anyMatch(entity -> !entity.equals(vehicle));
    }
}
