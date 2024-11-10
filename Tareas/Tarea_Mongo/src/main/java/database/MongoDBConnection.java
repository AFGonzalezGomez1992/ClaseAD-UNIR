package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class MongoDBConnection {
    private String connectionString = "mongodb+srv://%s:%s@cluster0.68elc.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    private MongoClient mongoClient;

    public MongoDBConnection(){
        mongoClient = MongoClients.create(String.format(connectionString, SchemaDB.user, SchemaDB.pass));
    }

    public MongoCollection getAlumnosCollection(){
        return mongoClient.getDatabase("centro_estudios").getCollection("alumnos");
    }

    public MongoCollection getProfesoresCollection(){
        return mongoClient.getDatabase("centro_estudios").getCollection("profesores");
    }
}
