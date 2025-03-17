package com.example.LigasAPI.service;

import com.example.LigasAPI.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();
    List<Usuario> getByCorreo(String correo);
    Usuario getUsuarioLogin(String correo, String pass);
    Usuario insertarUsuario(Usuario usuario);

}
