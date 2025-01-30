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
@Table(name = "posiciones")
public class Posicion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String posicion;

    @OneToMany(mappedBy = "posicion",fetch = FetchType.EAGER)
    private List<Jugador> jugadores;

    public Posicion(String posicion) {
        this.posicion = posicion;
    }
}
