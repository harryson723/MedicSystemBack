package com.application.rest.persistence.impl;

import com.application.rest.entities.ScheduleServiceEntity;
import com.application.rest.persistence.IScheduleServiceDAO;
import com.application.rest.repository.ScheduleServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ScheduleServiceDAOImpl implements IScheduleServiceDAO {

    @Autowired
    private ScheduleServiceRepository scheduleServiceRepository;
    @Override
    public List<ScheduleServiceEntity> findAll() {
        return (List<ScheduleServiceEntity>) scheduleServiceRepository.findAll();
    }

    @Override
    public Optional<ScheduleServiceEntity> findById(Long id) {
        return scheduleServiceRepository.findById(id);
    }

    @Override
    public ScheduleServiceEntity save(ScheduleServiceEntity scheduleService) {
        return scheduleServiceRepository.save(scheduleService);
    }

    @Override
    public void deleteById(Long id) {
        scheduleServiceRepository.deleteById(id);
    }
}
