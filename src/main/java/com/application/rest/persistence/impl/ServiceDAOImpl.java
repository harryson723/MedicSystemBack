package com.application.rest.persistence.impl;

import com.application.rest.entities.ServiceEntity;
import com.application.rest.persistence.IServiceDAO;
import com.application.rest.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceDAOImpl implements IServiceDAO {

    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public List<ServiceEntity> findAll() {
        return (List<ServiceEntity>) serviceRepository.findAll();
    }

    @Override
    public Optional<ServiceEntity> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public ServiceEntity save(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }
}
