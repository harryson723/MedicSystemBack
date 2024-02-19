package com.application.rest.persistence;

import com.application.rest.entities.ScheduleServiceEntity;

import java.util.List;
import java.util.Optional;

public interface IScheduleServiceDAO {
    List<ScheduleServiceEntity> findAll();

    Optional<ScheduleServiceEntity> findById(Long id);

    ScheduleServiceEntity save(ScheduleServiceEntity scheduleService);

    void deleteById(Long id);
}
