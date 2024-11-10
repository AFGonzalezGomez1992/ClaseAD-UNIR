import dao.UsuariosDao;
import model.Usuario;

public class EntradaMongo {
    public static void main(String[] args) {
        UsuariosDao usuariosDao = new UsuariosDao();
        usuariosDao.insertarUsuario(new Usuario("Borja","Martin","correo@gmail.com",40));
    }
}
