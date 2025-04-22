package com.mycompany.mjl;

import com.mycompany.persistence.ConnectionDB;
import com.mycompany.persistence.Challenge;
import com.mycompany.view.Interface;
import javax.swing.JOptionPane;

public class MJL {
    public static void main(String[] args) {
        try {
            ConnectionDB connection = new ConnectionDB();
            Challenge challenge = new Challenge(connection.getRetos());
            connection.closeConnection();
            
            Interface ui = new Interface();
            ui.setVisible(true); 
        
        // 💡 Enviar los valores iniciales de Challenge al iniciar
            
            ui.updateDates(challenge.getAttributes());
            ui.generateButtons(connection.totalRetos);
            
            

            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "⚠ Ha ocurrido un error inesperado:\n" + e.getMessage(),
                    "Error en la aplicación", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    
            
            
     