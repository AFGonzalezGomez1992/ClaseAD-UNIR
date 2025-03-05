package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "librerias")
public class Libreria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nombreDueno;

    @Embedded
    private Direccion direccion;

    @ManyToMany
    @JoinTable(
            name = "libreria_libros",
            joinColumns = @JoinColumn(name = "id_libreria"),
            inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private List<Libro> libros;

    public Libreria(String nombre, String nombreDueno, Direccion direccion) {
        this.nombre = nombre;
        this.nombreDueno = nombreDueno;
        this.direccion = direccion;
    }
}
