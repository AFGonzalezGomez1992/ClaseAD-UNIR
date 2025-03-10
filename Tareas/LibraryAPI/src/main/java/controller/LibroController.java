package controller;
import model.Libro;
import service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/add")
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.agregarLibro(libro), HttpStatus.OK);
    }

    @GetMapping("/getByLibreria")
    public ResponseEntity<List<Libro>> getLibrosPorLibreria(@RequestParam int libreriaId) {
        return new ResponseEntity<>(libroService.getLibrosPorLibreria(libreriaId), HttpStatus.OK);
    }
}