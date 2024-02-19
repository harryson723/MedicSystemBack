package com.application.rest.repository;

import com.application.rest.entities.ServiceRequestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository extends CrudRepository<ServiceRequestEntity, Long> {
}
