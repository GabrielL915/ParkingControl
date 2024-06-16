package com.gabrielgomes.parking_control.service;

import com.gabrielgomes.parking_control.domain.Apartment;
import com.gabrielgomes.parking_control.domain.dto.ApartmentDTO;
import com.gabrielgomes.parking_control.domain.repository.ApartmentRepository;
import com.gabrielgomes.parking_control.service.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService extends CRUDService<Apartment, Long, ApartmentDTO> {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    protected void updateData(Apartment apartment, ApartmentDTO apartmentDTO) {
        checkBeforeSave(apartmentDTO, apartment);
        apartment.setNumber(apartmentDTO.getNumber());
        apartment.setOwner(ownerMapper.toEntity(apartmentDTO.getOwnerDTO()));
    }

    @Override
    protected void checkBeforeSave(ApartmentDTO apartmentDTO, Apartment apartment) {

    }

    private boolean entityAlreadyExists(ApartmentDTO apartmentDTO, Apartment apartment) {
        return apartmentRepository.findByNumber(apartmentDTO.getNumber())
                .stream()
                .anyMatch(entity -> !entity.equals(apartment));
    }
}
