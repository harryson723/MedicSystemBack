package com.application.rest.persistence.impl;

import com.application.rest.entities.SuscriptionEntity;
import com.application.rest.persistence.ISuscriptionDAO;
import com.application.rest.repository.SuscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class SuscriptionDAOImpl implements ISuscriptionDAO {

    @Autowired
    private SuscriptionRepository suscriptionRepository;
    @Override
    public List<SuscriptionEntity> findAll() {
        return (List<SuscriptionEntity>) suscriptionRepository.findAll();
    }

    @Override
    public Optional<SuscriptionEntity> findById(Long id) {
        return suscriptionRepository.findById(id);
    }

    @Override
    public SuscriptionEntity save(SuscriptionEntity suscription) {
        return suscriptionRepository.save(suscription);
    }

    @Override
    public void deleteById(Long id) {
        suscriptionRepository.deleteById(id);
    }
}
