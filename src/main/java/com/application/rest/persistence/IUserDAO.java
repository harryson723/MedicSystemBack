package com.application.rest.persistence;

import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);
    List<UserEntity> findByRolesName(RolType roleName);

    Optional<UserEntity> findByDocumentNumber(String documentNumber);

    UserEntity save(UserEntity user);

    void deleteById(Long id);
}
