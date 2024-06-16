package com.gabrielgomes.parking_control.service;

import com.gabrielgomes.parking_control.domain.repository.CRUDRepository;
import com.gabrielgomes.parking_control.service.exception.EntityNotFoundException;
import com.gabrielgomes.parking_control.service.mapper.ParkingControlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CRUDService<Entity, ID, DTO> {

    @Autowired
    private CRUDRepository<Entity, ID> crudRepository;

    @Autowired
    private ParkingControlMapper<Entity, DTO> parkingControlMapper;

    public DTO create(DTO dto) {
        Entity newEntity = parkingControlMapper.toEntity(dto);
        checkBeforeSave(dto, newEntity);
        return parkingControlMapper.toDTO(crudRepository.save(newEntity));
    }

    public List<DTO> findAll() {
        return crudRepository.findAll()
                .stream()
                .map(parkingControlMapper::toDTO)
                .toList();
    }

    public DTO findById(ID id) {
        return parkingControlMapper.toDTO(findByIdOrElseThrowEntityNotFoundException(id));
    }

    public DTO update(ID id, DTO dto) {
        Entity entityToUpdate = findByIdOrElseThrowEntityNotFoundException(id);
        updateData(entityToUpdate, dto);
        return parkingControlMapper.toDTO(crudRepository.save(entityToUpdate));
    }

    public void delete(ID id) {
        crudRepository.delete(findByIdOrElseThrowEntityNotFoundException(id));
    }

    private Entity findByIdOrElseThrowEntityNotFoundException(ID id) {
        return crudRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    protected abstract void updateData(Entity entity, DTO dto);

    protected abstract void checkBeforeSave(DTO dto, Entity entity);
}
