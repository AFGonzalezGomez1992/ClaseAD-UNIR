package com.example.LigasAPI.service;

import com.example.LigasAPI.model.Usuario;
import com.example.LigasAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getByCorreo(String correo) {
        return usuarioRepository.getByCorreo(correo);
    }

    @Override
    public Usuario getUsuarioLogin(String correo, String pass) {
        return usuarioRepository.getByCorreoPass(correo, pass);
    }

    @Override
    public Usuario insertarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
