package com.prueba.ApiRestful.UserCrud.infrastructure.repository;

import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);
}
