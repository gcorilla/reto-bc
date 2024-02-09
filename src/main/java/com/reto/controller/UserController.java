package com.reto.controller;

import com.reto.model.UserModel;
import com.reto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    @Autowired
    private UserService userService;

    //@Autowired
    //private BCryptPasswordEncoder passwordEncoder;

    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarUsuario(@RequestBody UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userService.crearUsuario(userModel);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuarioPorId(@PathVariable Integer id){
        userService.eliminarUsuarioById(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }

    @GetMapping
    public List<UserModel> getAllUsers(){
        return userService.obtenerTodosLosUsuarios();
    }

}
