package com.prueba.ApiRestful.UserCrud.infrastructure.controller;


import com.prueba.ApiRestful.UserCrud.application.service.AuthService;
import com.prueba.ApiRestful.UserCrud.domain.model.AuthResponse;
import com.prueba.ApiRestful.UserCrud.domain.model.LoginRequest;
import com.prueba.ApiRestful.UserCrud.domain.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
