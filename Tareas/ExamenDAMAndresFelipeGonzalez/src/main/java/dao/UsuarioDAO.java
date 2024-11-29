package dao;

import database.DBScheme;
import database.DataBaseConnection;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        this.connection = new DataBaseConnection().getConnection();
    }

    public boolean registrarUsuario(Usuario usuario) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + DBScheme.TAB_USER + " WHERE " + DBScheme.COL_MAIL + " = ?";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, usuario.getCorreo());
            ResultSet rs = prepareStatement.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                return false;
            }
        }

        query = "INSERT INTO " + DBScheme.TAB_USER + " (" + DBScheme.COL_NAME + ", " + DBScheme.COL_PASS + ", " + DBScheme.COL_MAIL + ") VALUES (?, ?, ?)";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, usuario.getNombre());
            prepareStatement.setString(2, usuario.getPass());
            prepareStatement.setString(3, usuario.getCorreo());
            prepareStatement.executeUpdate();
        }

        return true;
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM " + DBScheme.TAB_USER;
        try (PreparedStatement prepareStatement = connection.prepareStatement(query);
             ResultSet rs = prepareStatement.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt(DBScheme.COL_ID),
                        rs.getString(DBScheme.COL_NAME),
                        rs.getString(DBScheme.COL_MAIL),
                        rs.getString(DBScheme.COL_PASS)
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public boolean comprobarCredenciales(String correo, String pass) throws SQLException {
        String query = "SELECT * FROM " + DBScheme.TAB_USER + " WHERE " + DBScheme.COL_MAIL + " = ? AND " + DBScheme.COL_PASS + " = ?";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, correo);
            prepareStatement.setString(2, pass);
            ResultSet rs = prepareStatement.executeQuery();
            return rs.next();
        }
    }

    public void exportarUsuariosAFichero(List<Usuario> usuarios) {
    }
}

