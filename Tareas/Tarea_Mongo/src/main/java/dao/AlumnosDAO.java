package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import database.MongoDBConnection;
import model.Alumnos;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO {

    MongoCollection collectionAlumnos;
    public AlumnosDAO(){
        collectionAlumnos = new MongoDBConnection().getAlumnosCollection();
    }


    public void insertarAlumnos(List<Alumnos> listaAlumnos) {
        List<Document> listaInsercion = new ArrayList<>();

        for (Alumnos alumno : listaAlumnos) {
            Document doc = new Document()
                    .append("id", alumno.getId())
                    .append("rating", alumno.getRating())
                    .append("age", alumno.getAge())
                    .append("name", alumno.getName())
                    .append("gender", alumno.getGender())
                    .append("email", alumno.getEmail())
                    .append("phone", alumno.getPhone())
                    .append("calificaation", alumno.getCalificaation())
                    .append("higher_grade", alumno.getHigher_grade());

            listaInsercion.add(doc);
        }

        collectionAlumnos.insertMany(listaInsercion);
    }

    //5. Obtener todos los alumnos que están matriculados en DAM

    public void alumnosDam (List<Alumnos> listaAlumnos){
        Document filtroDam = new Document().append("higher_grade","DAM");
        FindIterable resultado = collectionAlumnos.find(filtroDam);
        MongoCursor<Document> cursor = resultado.iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            String nombre = document.getString("name");
            String higher_grade = document.getString("higher_grade");
            System.out.printf("El alumno %s esta matriculado en %s ",nombre,higher_grade);
        }
    }

    //6. Obtener todos los alumnos que tienen más de 20 años

    public void alumnosMayores (List<Alumnos> listaAlumnos){
        Document filtroEdad = new Document().append("age", new Document().append("$gt",20));
        FindIterable resultado = collectionAlumnos.find(filtroEdad);
        MongoCursor<Document> cursor = resultado.iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            String nombre = document.getString("name");
            int edad = document.getInteger("age");
            System.out.println(nombre +" "+ edad);

        }
    }

    //12. Actualizar la edad del alumno cuyo correo es aprilmanning@proflex.com a 32

    public void actualizarEdadCorreo (List<Alumnos> listaAlumnos){
        Document documentBusqueda = new Document().append("email","aprilmanning@proflex.com");
        Document documentoCambio = new Document().append("$set",new Document("age",32));
        UpdateResult result = collectionAlumnos.updateMany(documentBusqueda,documentoCambio);
        System.out.printf("El resultado de la actualizacion han sido %d registros", result.getModifiedCount());
    }

    //13. Actualizar la edad de todos los alumnos del ciclo de DAM en un año

    public void actualizarEdad(List<Alumnos> listaAlumnos){
        Document documentBusqueda = new Document().append("age", new Document("$gt",0));
        Document documentoCambio = new Document().append("$set",new Document("age",+1));
        UpdateResult result = collectionAlumnos.updateMany(documentBusqueda,documentoCambio);
        System.out.printf("El resultado de la actualizcion han sido %d resgistros",result.getModifiedCount());;
    }

    //14. Actualizar todos los alumnos y añade el campo FCTs puesto como true

    public void anadirFCT(List<Alumnos> listaAlumnos){
        Document documentBusqueda = new Document().append("age", new Document("$gt",0));
        Document documentoCambio = new Document().append("$push",new Document("FCT",true));
        UpdateResult result = collectionAlumnos.updateMany(documentBusqueda,documentoCambio);
        System.out.printf("El resultado de la actualizcion han sido %d resgistros",result.getModifiedCount());;
    }

    //15. Actualiza todos los alumnos documentos que tengan una nota inferior a 5 y pon las FCTs como false

    public void actualizarAlumnos(List<Alumnos> listaAlumnos){
        Document documentBusqueda = new Document().append("calificaation", new Document("$lt",5));
        Document documentoCambio = new Document().append("$set",new Document("FCT",false));
        UpdateResult result = collectionAlumnos.updateMany(documentBusqueda,documentoCambio);
        System.out.printf("El resultado de la actualizcion han sido %d resgistros",result.getModifiedCount());
    }

    //16. Elimina todos aquellos registros de los alumnos que tenga las FCTs como false

    public void borradoFalsos(List<Alumnos> listaAlumnos){
        Document document = new Document();
        document.append("FCT",false);
        DeleteResult deleteResult = collectionAlumnos.deleteMany(document);
        System.out.println("El resultado del borrado es: "+deleteResult.getDeletedCount());
    }
}
