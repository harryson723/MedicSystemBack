package com.application.rest.services.impl;

import com.application.rest.entities.SuscriptionEntity;
import com.application.rest.persistence.ISuscriptionDAO;
import com.application.rest.services.ISuscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscriptionServiceImpl implements ISuscriptionService {
    @Autowired
    private ISuscriptionDAO suscriptionDAO;
    @Override
    public List<SuscriptionEntity> findAll() {
        return (List<SuscriptionEntity>) suscriptionDAO.findAll();
    }

    @Override
    public Optional<SuscriptionEntity> findById(Long id) {
        return suscriptionDAO.findById(id);
    }

    @Override
    public SuscriptionEntity save(SuscriptionEntity suscription) {
        return suscriptionDAO.save(suscription);
    }

    @Override
    public void deleteById(Long id) {
        suscriptionDAO.deleteById(id);
    }
}
