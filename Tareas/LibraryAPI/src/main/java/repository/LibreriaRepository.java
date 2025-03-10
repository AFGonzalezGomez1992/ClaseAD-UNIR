package repository;

import model.Libreria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibreriaRepository extends JpaRepository<Libreria, Integer> {
}
