package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    // si alguien pide una conexión,

        // si no esta -> la creo
    public Connection getConnection(){
        if (connection==null){
            //creo
            newConnection();
        }
        // si esta -> se la doy
        return connection;
    }

    private void newConnection() {
        // uri de conexion jdbc:mysql://127.0.0.1:3306/concesionario
        //                              localhost
        //String url = "jdbc:mysql://127.0.0.1:3306/concesionario";
        String url = "jdbc:mysql://127.0.0.1:3306/"+SchemaDB.DB_NAME;
        try {

            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            System.out.println("Error en la conexión de la base de datos");
        }
        System.out.println("Conexión creada correctamente");
    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion");
        }finally{
            connection = null;
        }
    }
}
