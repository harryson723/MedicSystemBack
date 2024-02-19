package com.application.rest.persistence;

import com.application.rest.entities.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceDAO {
    List<ServiceEntity> findAll();

    Optional<ServiceEntity> findById(Long id);

    ServiceEntity save(ServiceEntity service);

    void deleteById(Long id);
}
