package com.application.rest.services.impl;

import com.application.rest.entities.ServiceEntity;
import com.application.rest.persistence.IServiceDAO;
import com.application.rest.services.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements IServiceService {

    @Autowired
    private IServiceDAO serviceDAO;
    @Override
    public List<ServiceEntity> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public Optional<ServiceEntity> findById(Long id) {
        return serviceDAO.findById(id);
    }

    @Override
    public ServiceEntity save(ServiceEntity service) {
        return serviceDAO.save(service);
    }

    @Override
    public void deleteById(Long id) {
        serviceDAO.deleteById(id);
    }
}
