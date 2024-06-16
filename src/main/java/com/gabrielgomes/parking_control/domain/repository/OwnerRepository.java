package com.gabrielgomes.parking_control.domain.repository;

import com.gabrielgomes.parking_control.domain.Owner;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CRUDRepository<Owner, Long> {

    Optional<Owner> findByDocument(String document);
}
