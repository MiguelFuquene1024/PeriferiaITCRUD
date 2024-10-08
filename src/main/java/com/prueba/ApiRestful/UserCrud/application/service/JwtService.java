package com.prueba.ApiRestful.UserCrud.application.service;

import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String getJwtToken(UserDetails user);

    String getEmailFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
