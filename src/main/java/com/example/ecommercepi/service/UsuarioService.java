package com.example.ecommercepi.service;

import com.example.ecommercepi.model.Pedido;
import com.example.ecommercepi.model.Usuario;
import com.example.ecommercepi.repository.PedidoRepository;
import com.example.ecommercepi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public Iterable<Usuario> getAllUsers() {
        return this.usuarioRepository.findAll();
    }


    public Usuario create(Usuario user) {
        return this.usuarioRepository.save(user);
    }


    public void update(Usuario user) {
        this.usuarioRepository.save(user);
    }
}
