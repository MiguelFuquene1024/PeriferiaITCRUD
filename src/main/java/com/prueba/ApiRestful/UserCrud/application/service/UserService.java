package com.prueba.ApiRestful.UserCrud.application.service;

import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public User createUser(User user);

    public User updateUser(Long id,User user);

    public void deleteUser(Long id);

    public User getUser(Long id);

    public List<User> getUsers();
}
