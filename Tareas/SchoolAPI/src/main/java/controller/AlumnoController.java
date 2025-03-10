package controller;

import model.Alumno;
import service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/add")
    public ResponseEntity<Alumno> addAlumno(@RequestBody Alumno alumno) {
        return new ResponseEntity<>(alumnoService.agregarAlumno(alumno), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        return new ResponseEntity<>(alumnoService.getAllAlumnos(), HttpStatus.OK);
    }

    @GetMapping("/getByCurso")
    public ResponseEntity<List<Alumno>> getAlumnosPorCurso(@RequestParam int cursoId) {
        return new ResponseEntity<>(alumnoService.getAlumnosPorCurso(cursoId), HttpStatus.OK);
    }
}