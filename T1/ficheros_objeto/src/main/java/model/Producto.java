package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Producto implements Serializable {

    // variables - private

    // id
    private int id;
    private String title;
    private double price;
    private int stock;
    // constructores -> 1 -> vacio (solo si no hay otro escrito)


    public Producto(String title, double price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
}
