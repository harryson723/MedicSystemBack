package com.application.rest.services.impl;

import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;
import com.application.rest.persistence.IUserDAO;
import com.application.rest.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO userDAO;
    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userDAO.findAll();
    }

    @Override
    public List<UserEntity> findByRolesName(RolType roleName) {
        return (List<UserEntity>) userDAO.findByRolesName(roleName);
    }

    @Override
    public Optional<UserEntity> findByDocumentNumber(String documentNumber) {
        return userDAO.findByDocumentNumber(documentNumber);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
