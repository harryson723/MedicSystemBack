package com.application.rest.persistence;

import com.application.rest.entities.SuscriptionEntity;

import java.util.List;
import java.util.Optional;

public interface ISuscriptionDAO {
    List<SuscriptionEntity> findAll();

    Optional<SuscriptionEntity> findById(Long id);

    SuscriptionEntity save(SuscriptionEntity suscription);

    void deleteById(Long id);
}
