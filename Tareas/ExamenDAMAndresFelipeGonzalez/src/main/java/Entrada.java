import dao.UsuarioDAO;
import model.Usuario;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Comprobar credenciales");
            System.out.println("4. Exportar usuarios");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String pass = scanner.nextLine();

                    Usuario nuevoUsuario = new Usuario(0, nombre, apellido, correo, pass);
                    if (usuarioDAO.registrarUsuario(nuevoUsuario)) {
                        System.out.println("Usuario registrado con éxito.");
                    } else {
                        System.out.println("Error: Ya existe un usuario con ese correo.");
                    }
                    break;

                case 2:
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                    for (Usuario u : usuarios) {
                        System.out.println(u);
                    }
                    break;

                case 3:
                    System.out.print("Correo: ");
                    String correoLogin = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String passLogin = scanner.nextLine();

                    if (usuarioDAO.comprobarCredenciales(correoLogin, passLogin)) {
                        System.out.println("Login correcto.");
                    } else {
                        System.out.println("Login incorrecto.");
                    }
                    break;

                case 4:
                    List<Usuario> usuariosParaExportar = usuarioDAO.listarUsuarios();
                    usuarioDAO.exportarUsuariosAFichero(usuariosParaExportar);
                    System.out.println("Usuarios exportados.");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
