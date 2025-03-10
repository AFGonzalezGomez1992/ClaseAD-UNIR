package repository;

import model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    @Query("SELECT l FROM Libro l WHERE l.libreria.id = :libreriaId")
    List<Libro> findLibrosByLibreriaId(@Param("libreriaId") int libreriaId);
}