package com.prueba.ApiRestful.UserCrud.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.AntPathRequestMatcherProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import java.util.List;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(csrf->
                       csrf.ignoringRequestMatchers(toH2Console()).disable())
               .headers(httpSecurityHeadersConfigurer -> {
                   httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> {
                       frameOptionsConfig.disable();
                   });
               })
               .authorizeHttpRequests(auth->auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-db/**")).permitAll()
                       .requestMatchers("/auth/**").permitAll()
                       .anyRequest().authenticated())
               //.authorizeRequests(authRequest -> authRequest.requestMatchers(antPa).permitAll()
               //.anyRequest().authenticated())
               .sessionManagement(sessionManagement ->
                       sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .authenticationProvider(authProvider)
               .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
               .build();
    }
}
