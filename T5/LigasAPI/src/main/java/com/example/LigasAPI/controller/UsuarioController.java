package com.example.LigasAPI.controller;

import com.example.LigasAPI.model.Usuario;
import com.example.LigasAPI.service.LigaService;
import com.example.LigasAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/error")
    public String getError(){
        return "Error en la conexion";
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> addUser (@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.insertarUsuario(usuario), HttpStatus.OK);
    }

    @GetMapping ("/getMail")
    public ResponseEntity<List<Usuario>> getUserMail(@RequestParam String correo){
        return  new ResponseEntity<>(usuarioService.getByCorreo(correo),HttpStatus.OK);
    }

    @GetMapping ("/login")
    public ResponseEntity<Usuario> getUserLogin(@RequestParam String correo, @RequestParam String pass){//cantraseña nunca por @RequestParam

        Usuario usuario = usuarioService.getUsuarioLogin(correo,pass);

        if(usuario!=null){
            return  new ResponseEntity<>(usuario,HttpStatus.OK);
        }

        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // sacar el jasos de todos los usuarios de labase de datos

    @GetMapping("/getAll")
    public ResponseEntity<List<Usuario>> getAllUser(){
        List<Usuario> lista = usuarioService.getAllUsuarios();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<Usuario>(),HttpStatus.OK);
        }

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
