package com.prueba.ApiRestful.UserCrud.infrastructure;

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
    @PutMapping
    private ResponseEntity<?> actualizarUsuario(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @DeleteMapping(value = "{id}")
    private ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<?> obtenerUsuario(@RequestParam Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

}
