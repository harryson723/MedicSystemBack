package com.application.rest.services;

import com.application.rest.entities.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    List<ServiceEntity> findAll();

    Optional<ServiceEntity> findById(Long id);

    ServiceEntity save(ServiceEntity service);

    void deleteById(Long id);
}
