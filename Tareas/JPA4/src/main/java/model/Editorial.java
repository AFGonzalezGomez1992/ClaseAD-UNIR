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
@Table(name = "editoriales")
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Embedded
    private Direccion direccion;

    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    private List<Libro> libros;

    public Editorial(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
