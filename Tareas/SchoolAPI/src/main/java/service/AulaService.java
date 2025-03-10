package service;

import model.Aula;
import java.util.List;

public interface AulaService {
    List<Aula> getAulasPorCapacidad(int capacidad);
}
