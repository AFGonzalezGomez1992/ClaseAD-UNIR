package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import database.MongoDBConnection;
import model.Alumnos;
import model.Profesores;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ProfesoresDAO {
    MongoCollection collectionProfesores;

    public ProfesoresDAO() {
        collectionProfesores = new MongoDBConnection().getProfesoresCollection();
    }

    public void insertarProfesores(List<Profesores> listaProfesores) {
        List<Document> listaInsercion = new ArrayList<>();

        for (Profesores profesores : listaProfesores) {
            Document doc = new Document()
                    .append("id", profesores.getId())
                    .append("rating", profesores.getRating())
                    .append("age", profesores.getAge())
                    .append("name", profesores.getName())
                    .append("gender", profesores.getGender())
                    .append("email", profesores.getEmail())
                    .append("phone", profesores.getPhone())
                    .append("calificaation", profesores.getSubjects())
                    .append("higher_grade", profesores.getTitle());

            listaInsercion.add(doc);
        }

        collectionProfesores.insertMany(listaInsercion);
    }

    //7. Obtener todos los profesores que imparten la asignatura de Programacion

    public void profesoresProgramacion(List<Profesores> listaProfesores) {
        Document filtroAsignatura = new Document().append("subjects", "programacion multimedia");
        FindIterable resultado = collectionProfesores.find(filtroAsignatura);
        MongoCursor<Document> cursor = resultado.iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            String nombre = document.getString("name");
            System.out.println(nombre);
        }
    }

    //8. Obtener todos los profesores que son ingenieros informáticos

    public void ingenierosInformaticos(List<Profesores> listaProfesores) {
        Document filtroIngeniero = new Document().append("title", "ingeniero informatico");
        FindIterable resultado = collectionProfesores.find(filtroIngeniero);
        MongoCursor<Document> cursor = resultado.iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            String nombre = document.getString("name");
            System.out.println(nombre);
        }
    }

    //9. Obtener todos los profesores que tienen mensos de 40 años y más de 30

    public void filtroProfesores(List<Profesores> listaProfesores){
        Document filtroEdad = new Document().append("age", new Document().append("$gt",30).append("$lt",40));
        FindIterable resultado = collectionProfesores.find(filtroEdad);
        MongoCursor<Document> cursor = resultado.iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            String nombre = document.getString("name");
            int edad = document.getInteger("age");
            System.out.println(nombre + " " + edad);
        }
    }

    //10. Obtener el profesor mejor valorado
    
    /*public void mejorValorado(List<Profesores> listaProfesores){
        Document filtroValor = new Document().append("rating",new Document().append("$lte",10));
        FindIterable resultado = collectionProfesores.findOne(filtroValor);
        MongoCursor<Document> cursor = resultado.iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            String nombre = document.getString("name");
            ;
            System.out.println(nombre);
        }
    }*/

    //11. Obtener el profesor que mas asignaturas imparte

    //17. Elimina todos aquellos profesores que tienen una calificacion entre 1 y 4

    public void eliminarProfesor(List<Profesores> listaProfesores){
        Document document = new Document();
        document.append("rating", new Document().append("$gte",1).append("$lte",4));
        DeleteResult deleteResult = collectionProfesores.deleteMany(document);
        System.out.println("El resultado del borrado es: "+deleteResult.getDeletedCount());
    }
}
