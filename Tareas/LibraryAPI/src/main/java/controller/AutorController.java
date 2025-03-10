package controller;
import model.Autor;
import service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping("/add")
    public ResponseEntity<Autor> addAutor(@RequestBody Autor autor) {
        return new ResponseEntity<>(autorService.agregarAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Autor>> getAllAutores() {
        return new ResponseEntity<>(autorService.getAllAutores(), HttpStatus.OK);
    }
}