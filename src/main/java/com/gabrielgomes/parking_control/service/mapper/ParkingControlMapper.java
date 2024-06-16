package com.gabrielgomes.parking_control.service.mapper;

public interface ParkingControlMapper<Entity, DTO> {

    DTO toDTO(Entity entity);

    Entity toEntity(DTO dto);
}
