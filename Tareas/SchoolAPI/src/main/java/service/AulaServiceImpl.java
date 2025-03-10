package service;

import model.Aula;
import repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AulaServiceImpl implements AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> getAulasPorCapacidad(int capacidad) {
        return aulaRepository.findByCapacidadGreaterThan(capacidad);
    }
}
