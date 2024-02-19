package com.application.rest.persistence;

import com.application.rest.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity user);

    void deleteById(Long id);
}
