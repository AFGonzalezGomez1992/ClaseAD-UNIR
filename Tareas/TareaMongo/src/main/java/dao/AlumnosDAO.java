package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Alumno;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class AlumnosDAO {
    private final MongoCollection<Document> collection;

    public AlumnosDAO(MongoDatabase database) {
        this.collection = database.getCollection("alumnos");
    }

    public void insertarAlumno(Alumno alumno) {
        Document doc = new Document()
                .append("_id", alumno.getId())
                .append("rating", alumno.getRating())
                .append("age", alumno.getAge())
                .append("name", alumno.getName())
                .append("gender", alumno.getGender())
                .append("email", alumno.getEmail())
                .append("phone", alumno.getPhone())
                .append("calification", alumno.getCalification())
                .append("higher_grade", alumno.getHigherGrade());
        collection.insertOne(doc);
    }

    public List<Alumno> obtenerTodos() {
        List<Alumno> alumnos = new ArrayList<>();
        for (Document doc : collection.find()) {
            alumnos.add(new Alumno(
                    doc.getString("_id"),
                    doc.getDouble("rating"),
                    doc.getInteger("age"),
                    doc.getString("name"),
                    doc.getString("gender"),
                    doc.getString("email"),
                    doc.getString("phone"),
                    doc.getInteger("calification"),
                    doc.getString("higher_grade")
            ));
        }
        return alumnos;
    }

    public void eliminarPorCalificacion(int minCalificacion) {
        collection.deleteMany(gte("calification", minCalificacion));
    }
}
