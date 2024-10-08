package com.prueba.ApiRestful.UserCrud.application.service;

import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long id);

    public User getUser(Long id);
}
