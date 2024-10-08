package com.prueba.ApiRestful.UserCrud.infrastructure.adapter;

import com.prueba.ApiRestful.UserCrud.application.service.UserService;
import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import com.prueba.ApiRestful.UserCrud.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.findById(user.getId()).get();
        user1.setNombre(user.getNombre());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }
}
