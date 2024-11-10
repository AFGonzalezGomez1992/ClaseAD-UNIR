package dao;

import com.mongodb.client.MongoCollection;
import database.MongoDBConection;
import model.Usuario;
import org.bson.Document;

public class UsuariosDao {

    MongoCollection coleccionUsuarios;

    public UsuariosDao(){
        coleccionUsuarios = new MongoDBConection().getUserCollection();
    }

    public void insertarUsuario(Usuario usuario){
        Document document= new Document().append("nombre", usuario.getNombre())
                .append("apellido",usuario.getApellido())
                .append("correo",usuario.getCorreo())
                .append("edad",usuario.getEdad());
        coleccionUsuarios.insertOne(document);
    }
    public void getUsuarios(String mail){
        // new Document.append("correo",mail)
        // collection.find(documento)-> cursor -> while
    }
}
