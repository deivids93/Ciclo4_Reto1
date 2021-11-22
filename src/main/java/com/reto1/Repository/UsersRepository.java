/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto1.Repository;

import com.reto1.Repository.crud.UserCrudRepository;
import com.reto1.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public class UsersRepository {
    
     @Autowired
    private UserCrudRepository userCrudRepository;
     
     public List<Usuario> getAll() {
        return (List<Usuario>) userCrudRepository.findAll();
    }
   

    public Optional<Usuario> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public Usuario save(Usuario user) {
        return userCrudRepository.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<Usuario> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<Usuario> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    
}
