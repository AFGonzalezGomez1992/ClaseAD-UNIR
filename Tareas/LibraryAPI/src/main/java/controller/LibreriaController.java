package controller;

import model.Libreria;
import service.LibreriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/librerias")
public class LibreriaController {
    @Autowired
    private LibreriaService libreriaService;

    @PostMapping("/add")
    public ResponseEntity<Libreria> addLibreria(@RequestBody Libreria libreria) {
        return new ResponseEntity<>(libreriaService.agregarLibreria(libreria), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Libreria>> getAllLibrerias() {
        return new ResponseEntity<>(libreriaService.getAllLibrerias(), HttpStatus.OK);
    }
}