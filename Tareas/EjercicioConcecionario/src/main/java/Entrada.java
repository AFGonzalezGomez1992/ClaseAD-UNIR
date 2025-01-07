import dao.CochesDAO;
import dao.PasajerosDAO;
import model.Coche;
import model.Pasajero;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CochesDAO cochesDAO = new CochesDAO();
        PasajerosDAO pasajerosDAO = new PasajerosDAO();
        int opcion;

        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche por id");
            System.out.println("3. Consulta coche por id");
            System.out.println("4. Listado de coches");
            System.out.println("5. Gestión de pasajeros");
            System.out.println("6. Terminar el programa");
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
                    gestionPasajeros(scanner, pasajerosDAO, cochesDAO);
                    break;
                case 6:
                    cochesDAO.escribirCoches();
                    pasajerosDAO.escribirPasajeros();
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);

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

    private static void gestionPasajeros(Scanner scanner, PasajerosDAO pasajerosDAO, CochesDAO cochesDAO) {
        int opcion;
        do {
            System.out.println("\nGestión de Pasajeros:");
            System.out.println("1. Añadir nuevo pasajero");
            System.out.println("2. Borrar pasajero por id");
            System.out.println("3. Consulta pasajero por id");
            System.out.println("4. Listar todos los pasajeros");
            System.out.println("5. Añadir pasajero a coche");
            System.out.println("6. Eliminar pasajero de un coche");
            System.out.println("7. Listar todos los pasajeros de un coche");
            System.out.println("8. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    anadirPasajero(scanner, pasajerosDAO);
                    break;
                case 2:
                    borrarPasajero(scanner, pasajerosDAO);
                    break;
                case 3:
                    consultarPasajero(scanner, pasajerosDAO);
                    break;
                case 4:
                    listarPasajeros(pasajerosDAO);
                    break;
                case 5:
                    anadirPasajeroACoche(scanner, pasajerosDAO, cochesDAO);
                    break;
                case 6:
                    eliminarPasajeroDeCoche(scanner, pasajerosDAO, cochesDAO);
                    break;
                case 7:
                    listarPasajerosDeCoche(scanner, pasajerosDAO, cochesDAO);
                    break;
                case 8:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 8);
    }

    private static void anadirPasajero(Scanner scanner, PasajerosDAO pasajerosDAO) {
        System.out.print("Introduce el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        System.out.print("Introduce el peso: ");
        double peso = scanner.nextDouble();

        pasajerosDAO.anadirPasajero(new Pasajero(id, nombre, edad, peso));
        System.out.println("Pasajero añadido correctamente.");
    }

    private static void borrarPasajero(Scanner scanner, PasajerosDAO pasajerosDAO) {
        System.out.print("Introduce el ID del pasajero a borrar: ");
        int id = scanner.nextInt();
        pasajerosDAO.borrarPasajero(id);
        System.out.println("Pasajero borrado correctamente.");
    }

    private static void consultarPasajero(Scanner scanner, PasajerosDAO pasajerosDAO) {
        System.out.print("Introduce el ID del pasajero a consultar: ");
        int id = scanner.nextInt();
        Pasajero pasajero = pasajerosDAO.consultarPasajero(id);
        if (pasajero != null) {
            System.out.println(pasajero);
        } else {
            System.out.println("Pasajero no encontrado.");
        }
    }

    private static void listarPasajeros(PasajerosDAO pasajerosDAO) {
        if (pasajerosDAO.listarPasajeros().isEmpty()) {
            System.out.println("No hay pasajeros en el listado.");
        } else {
            for (Pasajero pasajero : pasajerosDAO.listarPasajeros()) {
                System.out.println(pasajero);
            }
        }
    }

    private static void anadirPasajeroACoche(Scanner scanner, PasajerosDAO pasajerosDAO, CochesDAO cochesDAO) {
        System.out.print("Introduce el ID del pasajero: ");
        int idPasajero = scanner.nextInt();
        System.out.print("Introduce el ID del coche: ");
        int idCoche = scanner.nextInt();

        pasajerosDAO.anadirPasajeroACoche(idPasajero, idCoche);
        System.out.println("Pasajero añadido al coche correctamente.");
    }

    private static void eliminarPasajeroDeCoche(Scanner scanner, PasajerosDAO pasajerosDAO, CochesDAO cochesDAO) {
        System.out.print("Introduce el ID del pasajero: ");
        int idPasajero = scanner.nextInt();
        System.out.print("Introduce el ID del coche: ");
        int idCoche = scanner.nextInt();

        pasajerosDAO.eliminarPasajeroDeCoche(idPasajero, idCoche);
        System.out.println("Pasajero eliminado del coche correctamente.");
    }

    private static void listarPasajerosDeCoche(Scanner scanner, PasajerosDAO pasajerosDAO, CochesDAO cochesDAO) {
        System.out.print("Introduce el ID del coche: ");
        int idCoche = scanner.nextInt();

        pasajerosDAO.listarPasajerosDeCoche(idCoche).forEach(System.out::println);
    }
}