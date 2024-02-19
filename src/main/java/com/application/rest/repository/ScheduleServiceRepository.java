package com.application.rest.repository;

import com.application.rest.entities.ScheduleServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleServiceRepository extends CrudRepository<ScheduleServiceEntity, Long> {
}
