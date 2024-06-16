package com.gabrielgomes.parking_control.domain.repository;

import com.gabrielgomes.parking_control.domain.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends CRUDRepository<Vehicle, Long> {

    Optional<Vehicle> findByLicensePlate(String licensePlate);
}
