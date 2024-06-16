package com.gabrielgomes.parking_control.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CRUDRepository<Entity, ID> extends JpaRepository<Entity, ID> { }
