/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto1.web;

import com.reto1.modelo.Usuario;
import com.reto1.servicios.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    
       @Autowired
    private UsersService service;
       
     @GetMapping("/all")
    private List<Usuario> getAll() {
        return service.getAll();
    }
    
     @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario users) {
        return service.registrar(users);
    }
     @GetMapping("/{email}/{password}")
    public Usuario autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.autenticarUsuario(email, password);
    }
    
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return service.existeEmail(email);
    }
    
}
