package com.application.rest.services;

import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserEntity> findAll();
    List<UserEntity> findByRolesName(RolType roleName);

    Optional<UserEntity> findByDocumentNumber(String documentNumber);

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity user);

    void deleteById(Long id);
}
