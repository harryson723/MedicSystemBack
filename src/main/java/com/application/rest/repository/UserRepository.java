package com.application.rest.repository;

import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    List<UserEntity> findByRolesName(RolType roleName);

    Optional<UserEntity> findByDocumentNumberAndRolesName(String documentNumber, RolType roleName);
}
