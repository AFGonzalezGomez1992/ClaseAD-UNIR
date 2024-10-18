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
    private static final long serialVersionUID =23456L;
    private int id;
    private String title;
    private double price;
    private int stock;
    private int discont;
    private String brand;
    // constructores -> 1 -> vacio (solo si no hay otro escrito)


    public Producto(String title, double price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public void mostrarDatos(){
        System.out.println("serialVersionUID = " + serialVersionUID);
        System.out.println("id = " + id);
        System.out.println("title = " + title);
        System.out.println("price = " + price);
        System.out.println("stock = " + stock);
        System.out.println("discont = " + discont);
        System.out.println("brand = " + brand);
    }
}
