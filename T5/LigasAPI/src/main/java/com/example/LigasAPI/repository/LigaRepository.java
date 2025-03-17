package com.example.LigasAPI.repository;

import com.example.LigasAPI.model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// metodos que van contra base de datos
// tantos métodos"adicionales" como necesitemos
// los metodos por "defecto" me los da el JPA repository
    // persist
    // save
    // merge
    // list
    // get -> id
public interface LigaRepository extends JpaRepository<Liga, Integer> {

    Liga findByNombre(String nombre);
}
