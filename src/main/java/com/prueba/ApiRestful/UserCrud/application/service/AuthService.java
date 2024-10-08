package com.prueba.ApiRestful.UserCrud.application.service;

import com.prueba.ApiRestful.UserCrud.domain.model.AuthResponse;
import com.prueba.ApiRestful.UserCrud.domain.model.LoginRequest;
import com.prueba.ApiRestful.UserCrud.domain.model.RegisterRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);
}
