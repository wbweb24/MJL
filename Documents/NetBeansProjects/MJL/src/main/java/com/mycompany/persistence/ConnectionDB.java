package com.mycompany.persistence;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB { 
    private MongoClient mongoClient;
    private MongoDatabase database;
    

    public ConnectionDB() {
        mongoClient = MongoClients.create("mongodb://localhost:27017"); // Acceso a MongoDB
        database = mongoClient.getDatabase("miniapps_db"); // Acceso a la base de datos
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public List<Document> getAllRetos() {
        MongoCollection<Document> collection = database.getCollection("retos");
        return collection.find().into(new ArrayList<>());
    }
}
