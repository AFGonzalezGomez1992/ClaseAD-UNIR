package controller;
import model.Editorial;
import service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @PostMapping("/add")
    public ResponseEntity<Editorial> addEditorial(@RequestBody Editorial editorial) {
        return new ResponseEntity<>(editorialService.agregarEditorial(editorial), HttpStatus.OK);
    }
}