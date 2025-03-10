package repository;

import model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    @Query("SELECT p FROM Profesor p JOIN p.cursos c WHERE c.id = :cursoId")
    List<Profesor> findProfesoresByCursoId(@Param("cursoId") int cursoId);

    @Query("SELECT c.nombre FROM Curso c JOIN c.profesores p WHERE p.id = :profesorId")
    List<String> findCursosByProfesorId(@Param("profesorId") int profesorId);
}