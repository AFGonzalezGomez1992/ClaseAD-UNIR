package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coches {

    private static final long serialVersionUID = 1L;
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
}
