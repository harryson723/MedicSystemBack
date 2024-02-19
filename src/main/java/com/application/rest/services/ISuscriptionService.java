package com.application.rest.services;

import com.application.rest.entities.SuscriptionEntity;

import java.util.List;
import java.util.Optional;

public interface ISuscriptionService {
    List<SuscriptionEntity> findAll();

    Optional<SuscriptionEntity> findById(Long id);

    SuscriptionEntity save(SuscriptionEntity suscription);

    void deleteById(Long id);
}
