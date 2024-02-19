package com.application.rest.services;

import com.application.rest.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity user);

    void deleteById(Long id);
}
