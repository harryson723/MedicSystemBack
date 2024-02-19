package com.application.rest.repository;

import com.application.rest.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {
}
