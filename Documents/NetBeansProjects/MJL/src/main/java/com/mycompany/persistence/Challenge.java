package com.mycompany.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;

public class Challenge {
    private List<Document> challenges;
    
    private Map<String, Object> attributes; // Cambio de String a Object para evitar conversión y problemas de compatibilidad

    // Constructor, toma la lista pasada por parámetro, cuenta el numero de retos y establece el map de atributos con los valores del primer reto
    public Challenge(List<Document> challenges) {
        this.challenges = challenges;
        
        this.attributes = new HashMap<>(challenges.get(0));
        }
    
/*recorre manualmente el map, cambiado a c
    private void processChallenge(Document challengeDoc) {
        for (String key : challengeDoc.keySet()) {
            attributes.put(key, challengeDoc.get(key)); // Se almacena el valor sin conversión
        }
    }*/
    
//GETTERS
    

    public Map<String, Object> getAttributes() {
        return attributes;
    }

   public void updateChallenge(int index) {
        attributes.clear(); // Limpiar antes de actualizar los valores
        attributes.putAll(challenges.get(index)); // Copia los atributos del nuevo reto
    }
   
   

    
}










/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.mycompany.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author wbweb
 
public class Challenge {
    
    private List<Document> challenges;
    private int challengeCount;
    private Map<String, String> attributes;
    
   //Constructor
    public Challenge(List<Document> challenges){
        this.challenges = challenges;
        this.challengeCount = challenges.size();
        this.attributes = new HashMap<>();
        
        
        if (!challenges.isEmpty()){
            processChallenge(challenges.get(0));
        }
    }
    
    private void processChallenge(Document challengeDoc){
        for(String key: challengeDoc.keySet()){
            Object value = challengeDoc.get(key);
            if (value instanceof org.bson.types.ObjectId){
                value = value.toString();
            }
            attributes.put(key,challengeDoc.getString(key));
        }
    }
    public int getChallengeCount(){
        return challengeCount;
    }
    
    public Map<String, String> getAttributes(){
        return attributes;
    }
    
    public void updateChallenge(int index){
        attributes.clear();
        processChallenge(challenges.get(index));
    }
    
    */
    
    
    
    







