package controller;

import dao.CochesDAO;
import dao.EmpleadoDAO;
import dao.VentaDAO;
import database.DBConnection;
import database.SchemaDB;
import model.Coche;
import model.Empleado;

import java.sql.*;
import java.util.Scanner;

public class Concesionario {
    // Creade Read Update Delete
    // Statement ->"Query directa" -> INSERT INTO empleados (nombre, apellido,
    // correo, telefono) VALUES ('Andres', 'Gonzalez', 'agonzalez@correo', 1234)
        // true o false -> CREATE
        // nº filas afectadas -> UPDATE  DELETE

    // PrepareStatement -> "Query con template" -> INSERT INTO empleados (nombre, apellido,
    //    // correo, telefono) VALUES (?,?,?,?)
    // setInt(4,123)
    // setString(1,"Andres")
    // setString(2,"Gonzalez")
    // setString(3,"correo#correo.es")

    // Create Update Delete -> MODIFICAN TABLA
    // Read -> OBTIENE VECTOR DE VALORES

    // insertar trabajador
    private EmpleadoDAO empleadoDAO;
    private CochesDAO cochesDAO;
    private VentaDAO ventaDAO;

    public Concesionario(){
        empleadoDAO = new EmpleadoDAO();
        cochesDAO = new CochesDAO();
        ventaDAO = new VentaDAO();
    }
    public void insertarTrabajadorDAO(Empleado empleado){
        // la logica del negocio
        try {
            empleadoDAO.insertarEmpleado(empleado);
        } catch (SQLException e) {
            System.out.println("Error en la insercion del empleado");
        }
    }
    public void insetarTrabajador(Empleado empleado){
        //SchemaDB.nombre
        //Connection ->Statement (query) -> execute
        Connection connection = new DBConnection().getConnection();
        // ya puedo acceder a la base de datos
        try {
            Statement statement = connection.createStatement();
            String Psquery = String.format("INSERT INTO %s (%S,%s,%s,%s,%s) VALUES (?,?,?,?,?)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMP_NAME,SchemaDB.COL_EMP_SURNAME,SchemaDB.COL_EMP_MAIL,SchemaDB.COL_EMP_PHO, SchemaDB.COL_EMP_KIN);
            PreparedStatement preparedStatement = connection.prepareStatement(Psquery);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getApellido());
            preparedStatement.setString(3, empleado.getCorreo());
            preparedStatement.setInt(4,empleado.getTelefono());
            preparedStatement.setInt(5,empleado.getTipo().getId());
            preparedStatement.execute();
            /*String query = "insert into "+SchemaDB.TAB_EMP +
                    " ("+SchemaDB.COL_EMP_NAME+","+SchemaDB.COL_EMP_SURNAME+ ","+SchemaDB.COL_EMP_MAIL+","+SchemaDB.COL_EMP_PHO+") " +
                    "VALUES ('"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getCorreo()+"','"+empleado.getTelefono()+"')";*/
            // %s -> String
            // %d -> int
            // %f -> double o float
            // %b -> boolean
            // %c -> char
            String query = String.format("INSERT INTO %s (%S,%s,%s,%s) VALUES ('%s','%S','%s','%d')",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMP_NAME,SchemaDB.COL_EMP_SURNAME,SchemaDB.COL_EMP_MAIL,SchemaDB.COL_EMP_PHO,
                    empleado.getNombre(),empleado.getApellido(),empleado.getCorreo(),empleado.getTelefono());
            // statement.execute(query); // hay o no fallo
            // statement.executeUpdate(); // cuantas filas estan afectadas)
        } catch (SQLException e) {
            System.out.println("Error en la conexion de la base de datos");
        }

    }
    public void borrarUsuario(int id){
        Connection connection = new DBConnection().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM "+SchemaDB.TAB_EMP+" WHERE ID=?");
            preparedStatement.setInt(1,1);
            int row = preparedStatement.executeUpdate();
            System.out.println("El numero de registros borrados es de "+row);
        } catch (SQLException e) {
            System.out.println("Error en la creacion de la query");
        }
    }
    // lectura
    public void leerUsuarios(int tipo){
        //  no se puede mapear de forma directa -> Vectores[[nombre, apellido, correo],[nombre, apellido, correo]]
        // Connection ->Statement / PrepareStatement -> executeQuery -> ResultSet
        Connection connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM 5s WHERE %S=?",SchemaDB.TAB_EMP,SchemaDB.COL_EMP_KIN);
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,tipo);
            ResultSet resultSet = preparedStatement.executeQuery();
        //
            while (resultSet.next()){
                String nombre = resultSet.getNString(SchemaDB.COL_EMP_NAME);
                String correo = resultSet.getNString(SchemaDB.COL_EMP_MAIL);
                int tipo1 =resultSet.getInt(SchemaDB.COL_EMP_KIN);
                //System.out.println("Nombre del empleado "+nombre+" y su correo es: "+correo);
                System.out.printf("Nombre del empleado %s\n\tCorreo del empleado %s\n",nombre,correo);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }
    }


    public void agregarCoche(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce marca");
        String marca = scanner.next();


        // si me dicen una marca y ya tengo 8 cches de esa marca, no lo quiero comprar


        try {
            if(cochesDAO.getModeloCochesMarca(marca).size() < 2){
                System.out.println("introduce modelo");
                String modelo = scanner.next();
                System.out.println("Que caballos tiene");
                int cv = scanner.nextInt();
                System.out.println("Que precio tiene");
                int precio = scanner.nextInt();
                cochesDAO.addCoche(new Coche(marca,modelo,cv,precio));
                System.out.println("coche agregado con exito");
            }else {
                System.out.println("No interesa el coche al concesionario");
            }


        } catch (SQLException e) {
            System.out.println("<La base de datos no esta disponible, quieres guardar el objeto para mas adelante");
            //guardar el dato en un fichero -> DAO
        }
    }

    public void filtrarPrecio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por que precio quieres filtrar");
        int precio = scanner.nextInt();
        try {
            for (Coche coche: cochesDAO.getCochePrecio(precio)) {
                // mostrar los datos de los coches resultantes en la consola
                coche.mostrarDatos();
            }

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta, quieres hacer otra cosa");
        }

    }

    // tener la funcionalidada de vender un coche -> matricula
    // y el coche lo vende un vendedor (tengo que decir quien lo vende)
    // tener la funcionalidad de cual es el vendedor que mas coches ha vendido

    public void realizarVenta(){
        // pedido por scanner
        int idCoche=0;
        System.out.println("Dime el coche que vas a vender");
        int idEmpleado=0;
        System.out.println("Dime el vendedor que hace la venta");
        try {
            // el coche que estas vendiendo esta disponible?
                // si no esta disponible haz xxxxx
                    //buscar un coche con las mismas caracteristicas de cv y precio
                // si esta disponible, procede a registrar la venta
                    //* cochesDAO.realizarVenta(1);
                    //* empleadoDAO.realizarVenta(1);
            ventaDAO.realizarVenta(idEmpleado,idCoche);
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    public void mostrarEmpleadosMes(int numero){
        System.out.println("Die cuantos quieres sacar");
        int numeroEmpleados =0;
        try {
            empleadoDAO.obtenerEmpleadoMes(3);
        } catch (SQLException e) {
            System.out.println("Error a la hora de obtenerlos");
            System.out.println("Quieres hacer xxx");
        }
    }
}
