package com.application.rest.persistence.impl;

import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;
import com.application.rest.persistence.IUserDAO;
import com.application.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findByRolesName(RolType roleName)  {
        return userRepository.findByRolesName(roleName);
    }

    @Override
    public Optional<UserEntity> findByDocumentNumberAndRolesName(String documentNumber, RolType roleName) {
        return  userRepository.findByDocumentNumberAndRolesName(documentNumber, roleName);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
