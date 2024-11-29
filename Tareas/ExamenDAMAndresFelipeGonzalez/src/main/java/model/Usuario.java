package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String pass;

    @Override
    public String toString() {
        return "ID: " + id + " - Nombre: " + nombre;
    }
}
