package controller;

import model.Aula;
import service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/aulas")
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @GetMapping("/getCapacidad")
    public ResponseEntity<List<Aula>> getAulasPorCapacidad(@RequestParam int capacidad) {
        return new ResponseEntity<>(aulaService.getAulasPorCapacidad(capacidad), HttpStatus.OK);
    }
}
