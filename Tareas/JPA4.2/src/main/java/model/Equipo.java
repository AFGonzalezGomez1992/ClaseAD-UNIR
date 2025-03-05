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
@Table(name = "equipos")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Entrenador entrenador;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Deportista> deportistas;

    @ManyToMany
    @JoinTable(
            name = "equipo_evento",
            joinColumns = @JoinColumn(name = "id_equipo"),
            inverseJoinColumns = @JoinColumn(name = "id_evento")
    )
    private List<Evento> eventos;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
}
