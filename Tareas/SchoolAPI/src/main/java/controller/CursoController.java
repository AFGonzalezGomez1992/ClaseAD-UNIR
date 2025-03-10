package controller;

import model.Curso;
import service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/getByAula")
    public ResponseEntity<Curso> getCursoPorAula(@RequestParam int aulaId) {
        return new ResponseEntity<>(cursoService.getCursoPorAula(aulaId), HttpStatus.OK);
    }
}