package controller;

import model.Profesor;
import service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/add")
    public ResponseEntity<Profesor> addProfesor(@RequestBody Profesor profesor) {
        return new ResponseEntity<>(profesorService.agregarProfesor(profesor), HttpStatus.OK);
    }

    @GetMapping("/getByCurso")
    public ResponseEntity<List<Profesor>> getProfesoresPorCurso(@RequestParam int cursoId) {
        return new ResponseEntity<>(profesorService.getProfesoresPorCurso(cursoId), HttpStatus.OK);
    }

    @GetMapping("/getCursos")
    public ResponseEntity<List<String>> getCursosDeProfesor(@RequestParam int profesorId) {
        return new ResponseEntity<>(profesorService.getCursosDeProfesor(profesorId), HttpStatus.OK);
    }
}
