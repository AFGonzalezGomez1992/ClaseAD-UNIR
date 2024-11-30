package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Profesor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class ProfesoresDAO {
    private final MongoCollection<Document> collection;

    public ProfesoresDAO(MongoDatabase database) {
        this.collection = database.getCollection("profesores");
    }

    public void insertarProfesor(Profesor profesor) {
        Document doc = new Document()
                .append("_id", profesor.getId())
                .append("rating", profesor.getRating())
                .append("age", profesor.getAge())
                .append("name", profesor.getName())
                .append("gender", profesor.getGender())
                .append("email", profesor.getEmail())
                .append("phone", profesor.getPhone())
                .append("subjects", profesor.getSubjects())
                .append("title", profesor.getTitle());
        collection.insertOne(doc);
    }

    public List<Profesor> obtenerTodos() {
        List<Profesor> profesores = new ArrayList<>();
        for (Document doc : collection.find()) {
            profesores.add(new Profesor(
                    doc.getString("_id"),
                    doc.getDouble("rating"),
                    doc.getInteger("age"),
                    doc.getString("name"),
                    doc.getString("gender"),
                    doc.getString("email"),
                    doc.getString("phone"),
                    doc.getList("subjects", String.class),
                    doc.getString("title")
            ));
        }
        return profesores;
    }
}
