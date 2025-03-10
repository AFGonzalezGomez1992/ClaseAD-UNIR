package service;
import model.Alumno;

import java.util.List;
public interface AlumnoService {
    Alumno agregarAlumno(Alumno alumno);
    List<Alumno> getAllAlumnos();
    List<Alumno> getAlumnosPorCurso(int cursoId);
}