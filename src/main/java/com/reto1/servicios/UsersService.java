/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto1.servicios;

import com.reto1.Repository.UsersRepository;
import com.reto1.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class UsersService {
    
      @Autowired
    private UsersRepository userRepository;
     
    public List<Usuario> getAll() {
        return userRepository.getAll();
    }

    public Optional<Usuario> getUser(int id) {
        return userRepository.getUser(id);
    }
    
     public Usuario registrar(Usuario user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public Usuario autenticarUsuario(String email, String password) {
        Optional<Usuario> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new Usuario(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
    
}
