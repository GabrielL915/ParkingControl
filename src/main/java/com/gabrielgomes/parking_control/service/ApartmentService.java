package com.gabrielgomes.parking_control.service;

import com.gabrielgomes.parking_control.domain.Apartment;
import com.gabrielgomes.parking_control.domain.ParkingSpot;
import com.gabrielgomes.parking_control.domain.dto.ApartmentDTO;
import com.gabrielgomes.parking_control.domain.repository.ApartmentRepository;
import com.gabrielgomes.parking_control.domain.repository.ParkingSpotRepository;
import com.gabrielgomes.parking_control.service.exception.EntityAlreadyExistsException;
import com.gabrielgomes.parking_control.service.mapper.ApartmentMapper;
import com.gabrielgomes.parking_control.service.mapper.OwnerMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService extends CRUDService<Apartment, Long, ApartmentDTO> {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private ApartmentMapper apartmentMapper;

    @Transactional
    @Override
    public ApartmentDTO create(ApartmentDTO dto) {
        Apartment newApartment = apartmentMapper.toEntity(dto);
        checkBeforeSave(dto, newApartment);
        createParkingSpotIfNotExists(newApartment);
        Apartment savedApartment = apartmentRepository.save(newApartment);
        return apartmentMapper.toDTO(savedApartment);
    }

    @Override
    protected void updateData(Apartment apartment, ApartmentDTO apartmentDTO) {
        checkBeforeSave(apartmentDTO, apartment);
        apartment.setNumber(apartmentDTO.getNumber());
        apartment.setOwner(ownerMapper.toEntity(apartmentDTO.getOwnerDTO()));
    }

    @Override
    protected void checkBeforeSave(ApartmentDTO apartmentDTO, Apartment apartment) {
        if (entityAlreadyExists(apartmentDTO, apartment)) {
            throw new EntityAlreadyExistsException("A apartment with this number already exists");
        }
    }

    private boolean entityAlreadyExists(ApartmentDTO apartmentDTO, Apartment apartment) {
        return apartmentRepository.findByNumber(apartmentDTO.getNumber())
                .stream()
                .anyMatch(entity -> !entity.equals(apartment));
    }

    private void createParkingSpotIfNotExists(Apartment apartment) {
        parkingSpotRepository.findByNumber(apartment.getNumber())
                .orElseGet(() -> {
                    ParkingSpot newParkingSpot = ParkingSpot.builder()
                            .number(apartment.getNumber())
                            .apartment(apartment)
                            .build();
                    return parkingSpotRepository.save(newParkingSpot);
                });
    }
}
