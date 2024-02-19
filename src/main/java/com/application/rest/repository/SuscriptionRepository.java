package com.application.rest.repository;

import com.application.rest.entities.SuscriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptionRepository extends CrudRepository<SuscriptionEntity, Long> {
}
