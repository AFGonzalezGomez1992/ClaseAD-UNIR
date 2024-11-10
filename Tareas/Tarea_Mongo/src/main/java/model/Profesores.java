package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Profesores implements Serializable {

    private String id;
    private double rating;
    private  int age;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private List subjects;
    private String title;

}
