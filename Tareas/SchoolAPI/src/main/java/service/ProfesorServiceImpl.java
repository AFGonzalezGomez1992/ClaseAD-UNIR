package service;

import model.Profesor;
import repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public Profesor agregarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public List<Profesor> getProfesoresPorCurso(int cursoId) {
        return profesorRepository.findProfesoresByCursoId(cursoId);
    }

    @Override
    public List<String> getCursosDeProfesor(int profesorId) {
        return profesorRepository.findCursosByProfesorId(profesorId);
    }
}