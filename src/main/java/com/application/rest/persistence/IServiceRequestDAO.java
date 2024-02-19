package com.application.rest.persistence;

import com.application.rest.entities.ServiceRequestEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceRequestDAO {
    List<ServiceRequestEntity> findAll();

    Optional<ServiceRequestEntity> findById(Long id);

    ServiceRequestEntity save(ServiceRequestEntity serviceRequest);

    void deleteById(Long id);
}
