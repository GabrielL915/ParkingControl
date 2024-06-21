package com.gabrielgomes.parking_control.domain.repository;

import com.gabrielgomes.parking_control.domain.ParkingSpot;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends CRUDRepository<ParkingSpot, Long> {
    Optional<ParkingSpot> findByNumber(String number);
    boolean existsByNumber(String number);
}
