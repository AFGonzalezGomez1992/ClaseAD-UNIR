package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "entrenadores")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int experiencia; // Años de experiencia

    @OneToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Entrenador(String nombre, int experiencia, Equipo equipo) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.equipo = equipo;
    }
}
