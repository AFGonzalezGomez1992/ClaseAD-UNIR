import com.mongodb.client.MongoDatabase;
import dao.AlumnosDAO;
import dao.ProfesoresDAO;
import database.DataBaseConnection;
import model.Alumno;
import model.Profesor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlumnosDAO alumnosDAO = new AlumnosDAO((MongoDatabase) DataBaseConnection.getConnection());
        ProfesoresDAO profesoresDAO = new ProfesoresDAO((MongoDatabase) DataBaseConnection.getConnection());

        int option;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Insertar Alumno");
            System.out.println("2. Insertar Profesor");
            System.out.println("3. Mostrar Alumnos");
            System.out.println("4. Mostrar Profesores");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    Alumno alumno = new Alumno("1", 8.5, 20, "Juan Pérez", "male", "juan@example.com", "123456789", 9, "DAM");
                    alumnosDAO.insertarAlumno(alumno);
                    System.out.println("Alumno insertado.");
                }
                case 2 -> {
                    Profesor profesor = new Profesor("1", 9.8, 30, "Ana López", "female", "ana@example.com", "987654321", Arrays.asList("Matemáticas", "Programación"), "Ingeniero");
                    profesoresDAO.insertarProfesor(profesor);
                    System.out.println("Profesor insertado.");
                }
                case 3 -> {
                    List<Alumno> alumnos = alumnosDAO.obtenerTodos();
                    alumnos.forEach(System.out::println);
                }
                case 4 -> {
                    List<Profesor> profesores = profesoresDAO.obtenerTodos();
                    profesores.forEach(System.out::println);
                }
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 5);

        scanner.close();
    }
}
