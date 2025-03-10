package service;
import model.Autor;

import java.util.List;
public interface AutorService {
    Autor agregarAutor(Autor autor);
    List<Autor> getAllAutores();
}