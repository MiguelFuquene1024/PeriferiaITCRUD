package com.prueba.ApiRestful.UserCrud.infrastructure.controller;

import com.prueba.ApiRestful.UserCrud.application.service.UserService;
import com.prueba.ApiRestful.UserCrud.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("v1/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    private ResponseEntity<?> registrarUsuario(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));

    }
    @GetMapping
    private ResponseEntity<?> obtenerUsuarios(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping(value = "{id}")
    private ResponseEntity<?> obtenerUsuario(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }
    @PutMapping(value = "{id}")
    private ResponseEntity<?> actualizarUsuario(@PathVariable Long id,@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id,user));
    }
    @DeleteMapping(value = "{id}")
    private ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }


}
