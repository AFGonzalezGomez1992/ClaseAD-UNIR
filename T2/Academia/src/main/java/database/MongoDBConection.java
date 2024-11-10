package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class MongoDBConection {
     private String connectionString = "mongodb+srv://%s:%s@cluster0.68elc.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    private MongoClient mongoClient;

     public MongoDBConection(){
         mongoClient = MongoClients.create(String.format(connectionString, DBSchema.user, DBSchema.pass));
     }

     public MongoCollection getUserCollection(){
         return mongoClient.getDatabase("academia").getCollection("usuarios");
     }

}
