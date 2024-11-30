import dao.CochesDAO;
import model.Coche;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CochesDAO cochesDAO = new CochesDAO();
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche por id");
            System.out.println("3. Consulta coche por id");
            System.out.println("4. Listado de coches");
            System.out.println("5. Terminar el programa");
            System.out.println("6. Exportar coches a archivo CSV");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    anadirCoche(scanner, cochesDAO);
                    break;
                case 2:
                    borrarCoche(scanner, cochesDAO);
                    break;
                case 3:
                    consultarCoche(scanner, cochesDAO);
                    break;
                case 4:
                    listarCoches(cochesDAO);
                    break;
                case 5:
                    cochesDAO.escribirCoches();
                    System.out.println("Programa terminado.");
                    break;
                case 6:
                    cochesDAO.exportarCochesCSV();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void anadirCoche(Scanner scanner, CochesDAO cochesDAO) {
        System.out.print("Introduce el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Introduce la matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Introduce la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Introduce el modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Introduce el color: ");
        String color = scanner.nextLine();

        // Verificar duplicados
        if (cochesDAO.listarCoches().stream().anyMatch(coche -> coche.getId() == id || coche.getMatricula().equals(matricula))) {
            System.out.println("Error: El ID o la matrícula ya existe.");
            return;
        }

        cochesDAO.anadirCoche(new Coche(id, matricula, marca, modelo, color));
        System.out.println("Coche añadido correctamente.");
    }

    private static void borrarCoche(Scanner scanner, CochesDAO cochesDAO) {
        System.out.print("Introduce el ID del coche a borrar: ");
        int id = scanner.nextInt();
        cochesDAO.borrarCoche(id);
        System.out.println("Coche borrado correctamente.");
    }

    private static void consultarCoche(Scanner scanner, CochesDAO cochesDAO) {
        System.out.print("Introduce el ID del coche a consultar: ");
        int id = scanner.nextInt();
        Coche coche = cochesDAO.consultarCoche(id);
        if (coche != null) {
            System.out.println(coche);
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    private static void listarCoches(CochesDAO cochesDAO) {
        if (cochesDAO.listarCoches().isEmpty()) {
            System.out.println("No hay coches en el listado.");
        } else {
            for (Coche coche : cochesDAO.listarCoches()) {
                System.out.println(coche);
            }
        }
    }
}
