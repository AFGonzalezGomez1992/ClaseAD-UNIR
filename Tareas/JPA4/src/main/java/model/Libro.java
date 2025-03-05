package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "libros")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false)
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    public Libro(String titulo, double precio, Editorial editorial, Autor autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }
}
