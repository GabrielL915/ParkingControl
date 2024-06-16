package com.gabrielgomes.parking_control.service;

import com.gabrielgomes.parking_control.domain.Owner;
import com.gabrielgomes.parking_control.domain.dto.OwnerDTO;
import com.gabrielgomes.parking_control.domain.repository.OwnerRepository;
import com.gabrielgomes.parking_control.service.exception.EntityAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends CRUDService<Owner, Long, OwnerDTO> {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    protected void updateData(Owner owner, OwnerDTO ownerDTO) {
        checkBeforeSave(ownerDTO, owner);
        owner.setName(ownerDTO.getName());
        owner.setDocument(ownerDTO.getDocument());
    }

    @Override
    protected void checkBeforeSave(OwnerDTO ownerDTO, Owner owner) {
        if (entityAlreadyExists(ownerDTO, owner)) {
            throw new EntityAlreadyExistsException("An owner with this document already exists.");
        }
    }

    private boolean entityAlreadyExists(OwnerDTO ownerDTO, Owner owner) {
        return ownerRepository.findByDocument(ownerDTO.getDocument())
                .stream()
                .anyMatch(entity -> !entity.equals(owner));
    }
}
