package service;

import model.Libro;

import java.util.List;
public interface LibroService {
    Libro agregarLibro(Libro libro);
    List<Libro> getLibrosPorLibreria(int libreriaId);
}