package model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Direccion {

    private String localidad;
    private String provincia;

    @Override
    public String toString() {
        return localidad + ", " + provincia;
    }
}
