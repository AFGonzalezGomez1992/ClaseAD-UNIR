package service;

import model.Curso;
import repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso getCursoPorAula(int aulaId) {
        return cursoRepository.findByAulaId(aulaId);
    }
}