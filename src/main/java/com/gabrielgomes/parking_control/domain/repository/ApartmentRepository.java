package com.gabrielgomes.parking_control.domain.repository;

import com.gabrielgomes.parking_control.domain.Apartment;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends CRUDRepository<Apartment, Long> {

    Optional<Apartment> findByNumber(String number);
}
