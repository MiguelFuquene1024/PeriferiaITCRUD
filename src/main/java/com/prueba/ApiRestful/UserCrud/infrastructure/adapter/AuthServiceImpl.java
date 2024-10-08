package com.prueba.ApiRestful.UserCrud.infrastructure.adapter;

import com.prueba.ApiRestful.UserCrud.application.service.AuthService;
import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import com.prueba.ApiRestful.UserCrud.domain.model.AuthResponse;
import com.prueba.ApiRestful.UserCrud.domain.model.LoginRequest;
import com.prueba.ApiRestful.UserCrud.domain.model.RegisterRequest;
import com.prueba.ApiRestful.UserCrud.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtServiceImpl jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getJwtToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        User user= User.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getJwtToken(user))
                .build();

    }
}
