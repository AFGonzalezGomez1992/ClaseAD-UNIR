package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Empleado;
import model.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    //Statement
    // constructor por defecto
    public EmpleadoDAO(){
        connection = new DBConnection().getConnection();
    }
    public void insertarEmpleado(Empleado empleado) throws SQLException {
        preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s ($s,%s,%s,$s,$s) values (?,?,?,?,?)",
                SchemaDB.TAB_EMP,
                SchemaDB.COL_EMP_NAME, SchemaDB.COL_EMP_SURNAME, SchemaDB.COL_EMP_MAIL, SchemaDB.COL_EMP_PHO,SchemaDB.TAB_KIN));
        preparedStatement.setString(1, empleado.getNombre());
        preparedStatement.setString(2, empleado.getApellido());
        preparedStatement.setString(3, empleado.getCorreo());
        preparedStatement.setInt(4, empleado.getTelefono());
        preparedStatement.setInt(5, empleado.getTipo().getId());

        preparedStatement.execute();

    }

    public Empleado getEmpleado(int id) throws SQLException{
        preparedStatement = connection.prepareStatement(String.format("SELECT * FROM %s WHERE %s=?", SchemaDB.TAB_EMP, SchemaDB.COL_ID));
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            String nombre = resultSet.getString(SchemaDB.COL_EMP_NAME);
            String apellido = resultSet.getString(SchemaDB.COL_EMP_SURNAME);
            String correo = resultSet.getString(SchemaDB.COL_EMP_MAIL);
            int telefono = resultSet.getInt(SchemaDB.COL_EMP_PHO);
            int tipo = resultSet.getInt(SchemaDB.COL_EMP_KIN);
            return getEmpleado(nombre,apellido,correo,telefono,tipo);
        }
        return null;
    }
    public void realizarVenta(int id){
      // String query ="UPDATE %s SET %s = %s+1 WHERE %s =?";
       //preparedStatement = connection.prepareStatement(String.format(query,,SchemaDB.TAB_EMP));
    }
    public Empleado getEmpleado(String nombre, String apellido, String correo, int telefono, int tipo){
        Tipo tipo1 = null;
        switch (tipo){
            case 1:
                tipo1 = Tipo.EXTERNO;
                break;
            case 2:
                tipo1 = Tipo.INDEFINIDO;
                break;
            case 3:
                tipo1 = Tipo.BECARIO;
                break;

        }
        return new Empleado(nombre, apellido, correo, telefono,tipo1);
    }
}
