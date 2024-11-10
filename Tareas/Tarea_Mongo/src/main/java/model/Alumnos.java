package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Alumnos  implements Serializable {

    private String id;
    private double rating;
    private  int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private int calificaation;
    private String higher_grade;
}
