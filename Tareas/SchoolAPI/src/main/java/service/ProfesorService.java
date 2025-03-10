package service;

import model.Profesor;
import java.util.List;

public interface ProfesorService {
    Profesor agregarProfesor(Profesor profesor);
    List<Profesor> getProfesoresPorCurso(int cursoId);
    List<String> getCursosDeProfesor(int profesorId);
}