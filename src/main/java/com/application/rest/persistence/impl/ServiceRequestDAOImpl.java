package com.application.rest.persistence.impl;

import com.application.rest.entities.ServiceRequestEntity;
import com.application.rest.persistence.IServiceRequestDAO;
import com.application.rest.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceRequestDAOImpl implements IServiceRequestDAO {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;
    @Override
    public List<ServiceRequestEntity> findAll() {
        return (List<ServiceRequestEntity>) serviceRequestRepository.findAll();
    }

    @Override
    public Optional<ServiceRequestEntity> findById(Long id) {
        return serviceRequestRepository.findById(id);
    }

    @Override
    public ServiceRequestEntity save(ServiceRequestEntity serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    @Override
    public void deleteById(Long id) {
        serviceRequestRepository.deleteById(id);
    }
}
