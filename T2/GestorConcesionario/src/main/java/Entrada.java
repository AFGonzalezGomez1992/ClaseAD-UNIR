import controller.Concesionario;
import database.DBConnection;
import model.Empleado;
import model.Tipo;

import java.sql.Connection;

public class Entrada {
    public static void main(String[] args) {

        // TIPO 1, EXT
        // TIPO 2, IND
        // TIPO 3, BEC
        /*DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        //trabajas con la conexion
        dbConnection.closeConnection();
        DBConnection dbConnection2= new DBConnection();
        Connection connection2 = dbConnection.getConnection();*/
        // concesionario.insetarTrabajador(new Empleado("Juan1","Gomez","juan@gmail.com",567, Tipo.BECARIO));
        // concesionario.insetarTrabajador(new Empleado("Juan2","Gomez","juan@gmail.com",567, Tipo.INDEFINIDO));
        // concesionario.insetarTrabajador(new Empleado("Juan3","Gomez","juan@gmail.com",567, Tipo.EXTERNO));
        // concesionario.borrarUsuario(1);
        //concesionario.leerUsuarios(1);
        Concesionario concesionario = new Concesionario();
        concesionario.agregarCoche();




    }
}
