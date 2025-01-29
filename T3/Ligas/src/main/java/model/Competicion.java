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
@Table(name = "competiciones")
public class Competicion implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private  String descripcion;

    @ManyToMany(mappedBy = "competiciones", fetch = FetchType.EAGER)
    List<Equipo> equipos;

    public Competicion(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Competicion(String titulo) {
        this.titulo = titulo;
    }
}
