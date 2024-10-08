package com.prueba.ApiRestful.UserCrud.infrastructure.adapter;

import com.prueba.ApiRestful.UserCrud.application.service.UserService;
import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import com.prueba.ApiRestful.UserCrud.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id,User user) throws RuntimeException{
        Optional<User> user1 = null;
        try {
            user1 = userRepository.findById(id);
            user1.get().setNombre(user.getNombre());
            user1.get().setEmail(user.getEmail());
            user1.get().setPassword(user.getPassword());
            userRepository.save(user1.get());
        }catch (Exception e){
            throw new RuntimeException("User not found");
        }
        return user1.get();
    }

    @Override
    public void deleteUser(Long id) {
        User user = null;
        try{
            user = userRepository.findById(id).get();
        }catch (Exception e){
            throw new RuntimeException("User not found");
        }

        userRepository.delete(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

}
