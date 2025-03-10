package service;

import model.Libreria;

import java.util.List;
public interface LibreriaService {
    Libreria agregarLibreria(Libreria libreria);
    List<Libreria> getAllLibrerias();
}
