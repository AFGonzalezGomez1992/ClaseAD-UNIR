import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // LOGICA DE LA APP
        // MENU
        // PANTALLAS
        // ACTIVITYS
        // FORM

        // pedir datos y hacer la logica -> UNIQUE
        /*try {
            if (!usuarioDAO.insertUser(new Usuario("Borja","Martin","coreo@gmail.com","1234"))){
                System.out.println("Usuario insertado con exito");
            }else{
                System.out.println("Fallo en el proceso de insercion");
            }
        } catch (SQLException e) {
            System.out.println("Error en la ejecución. Es posible que el correo ya exista, queres volver a probar");
        }*/

        /*try {
            // 0
            Scanner scanner = new Scanner(System.in);
            System.out.println("Indica el correo que quieres borrar");
            String correo = scanner.next();
            int deleteRows = usuarioDAO.deletetUser(correo);
            System.out.println("El numero de registros borrados es de "+deleteRows);
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion");
        }*/

        /*try {
            for (Usuario item: usuarioDAO.getAllUsers()) {
                // JAVAMAIL
                item.getCorreo();
            }
            ; // sacarla en
        } catch (SQLException e) {
            System.out.println("Error en la ejecución");
        }*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Indicame el correo");
        String correo = scanner.next();
        System.out.println("Indicame la contraseña");
        String pass = scanner.next();
        try {
            if (usuarioDAO.getLogin(correo,pass)){
                System.out.println("Login correcto, adelante");
            }else {
                System.out.println("Login incorrecto, fallo");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
