package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Column (name = "valor_mercado")
    private String nombre;
    @Column
    private int valor;
    @Column
    private String nacionalidad;
    @Column
    private int goles;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_posicion")
    private Posicion posicion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Jugador(String nombre, int valor, String nacionalidad, int goles) {
        this.nombre = nombre;
        this.valor = valor;
        this.nacionalidad = nacionalidad;
        this.goles = goles;
    }

    public Jugador(String nombre, int valor, String nacionalidad) {
        this.nombre = nombre;
        this.valor = valor;
        this.nacionalidad = nacionalidad;
    }
}
