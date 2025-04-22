/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

 

public class Interface extends javax.swing.JFrame {

    public Interface() {/////////////////////////////___C_O_N_S_T_R_U_C_T_O_R___
        
    initComponents(); // Inicializa los componentes generados por NetBeans
    setLocationRelativeTo(null); // Centra la ventana
    setWelcomePanel(); 
    
    resizePanels();
    

    
    
     
    
    }
    
//******************************************************************************MÉTODOS USO INTERNO*********** 
    
    private void setWelcomePanel() {
    
    jPanel_welcome.setLayout(new BorderLayout());
    
    JLabel welcomeLine1 = new JLabel("Bienvenid@ a mi laboratorio de Java");
    welcomeLine1.setHorizontalAlignment(SwingConstants.CENTER);
    welcomeLine1.setFont(new Font("Arial", Font.BOLD, 36));
    welcomeLine1.setForeground(Color.WHITE);/**********************************/
    JLabel welcomeLine2 = new JLabel("Pincha para entrar");
    welcomeLine2.setHorizontalAlignment(SwingConstants.CENTER);
    welcomeLine2.setFont(new Font("Arial", Font.ITALIC, 20));
    welcomeLine2.setForeground(Color.WHITE);

    JPanel textContainer = new JPanel(new GridLayout(2, 1));
    textContainer.setOpaque(false); // Fondo transparente
    textContainer.add(welcomeLine1);
    textContainer.add(welcomeLine2);
    jPanel_welcome.add(textContainer, BorderLayout.CENTER);
    
    getContentPane().setComponentZOrder(jPanel_welcome, 0);//subirlo en el ejeZ
    revalidate();
    repaint();
    
    //////////////////////////////////////////////////////////////Comportamiento
    
    this.addComponentListener(new ComponentAdapter() {
    @Override
        public void componentResized(ComponentEvent e) {
            jPanel_welcome.setBounds(0, 0, getWidth(), getHeight());
            revalidate();
            repaint();
        }
    });
    
    jPanel_welcome.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        getContentPane().remove(jPanel_welcome); 
        revalidate();
        repaint();
    }
});

    }
    
    private void resizePanels() {
    // División vertical 
    JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jPanel_head, jPanel_app);
    verticalSplit.setResizeWeight(0.5); // Crecimiento proporcional
    

    // División horizontal 
    JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, verticalSplit, jPanel_index);
    mainSplit.setDividerLocation(0.7); 
    mainSplit.setResizeWeight(0.7); // Crecimiento proporcional
    mainSplit.setContinuousLayout(true); 

    
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(mainSplit, BorderLayout.CENTER);

    
    revalidate();
    repaint();
}
 
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////
//******************************************************************************METODOS USO EXTERNO*********
    ///////////////////////////////////////////////////////////////////////////////

    
    
    public void updateDates(Map<String, Object> attributes) {
    
    jLabel_title.setText((String) attributes.get("nombre"));
    jLabel1.setText((String) attributes.get("descripcion"));

    }   
    
    
    /*public void generateButtons(int num){
        for(int i = 1; i <= num; i++){
            JButton button = new JButton("Reto " + (i));
            jPanel_index.add(button);
            button.setPreferredSize(new Dimension(80, 30)); // Ancho: 80px, Alto: 30px
            
        }
        jPanel_index.setLayout(new GridLayout(0, 1)); // Una columna con múltiples filas
        jPanel_index.setLayout(new FlowLayout(FlowLayout.CENTER));

        jPanel_index.revalidate();
        jPanel_index.repaint();
        
    }*/
    public void generateButtons(int num) {
    jPanel_index.setLayout(new BoxLayout(jPanel_index, BoxLayout.Y_AXIS)); // Organización vertical

    int panelWidth = jPanel_index.getWidth();
    int buttonWidth = (int) (panelWidth * 0.60); // Botón ocupará el 60% del panel

    for (int i = 1; i <= num; i++) {
        JButton button = new JButton("Reto " + i);
        button.setPreferredSize(new Dimension(buttonWidth, 40)); // Tamaño del botón
        button.setMaximumSize(new Dimension(buttonWidth, 40)); // Evita que se expanda más
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrado en el panel
        
        jPanel_index.add(Box.createRigidArea(new Dimension(0, 15)));
        jPanel_index.add(new Box.Filler(
        new Dimension(0, 5),  // Tamaño mínimo
        new Dimension(0, 10),  // Tamaño preferido
        new Dimension(0, 20)   // Tamaño máximo
        ));

        jPanel_index.add(button);
    }

    jPanel_index.revalidate();
    jPanel_index.repaint();
}

        
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_index = new javax.swing.JPanel();
        jPanel_head = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_app = new javax.swing.JPanel();
        jPanel_welcome = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Java Lab");

        jPanel_index.setBackground(new java.awt.Color(255, 204, 153));

        javax.swing.GroupLayout jPanel_indexLayout = new javax.swing.GroupLayout(jPanel_index);
        jPanel_index.setLayout(jPanel_indexLayout);
        jPanel_indexLayout.setHorizontalGroup(
            jPanel_indexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel_indexLayout.setVerticalGroup(
            jPanel_indexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_head.setBackground(new java.awt.Color(255, 204, 153));

        jLabel_title.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel_headLayout = new javax.swing.GroupLayout(jPanel_head);
        jPanel_head.setLayout(jPanel_headLayout);
        jPanel_headLayout.setHorizontalGroup(
            jPanel_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_headLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_headLayout.setVerticalGroup(
            jPanel_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_headLayout.createSequentialGroup()
                .addComponent(jLabel_title, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_app.setBackground(new java.awt.Color(255, 255, 204));

        jPanel_welcome.setBackground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout jPanel_welcomeLayout = new javax.swing.GroupLayout(jPanel_welcome);
        jPanel_welcome.setLayout(jPanel_welcomeLayout);
        jPanel_welcomeLayout.setHorizontalGroup(
            jPanel_welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel_welcomeLayout.setVerticalGroup(
            jPanel_welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel_appLayout = new javax.swing.GroupLayout(jPanel_app);
        jPanel_app.setLayout(jPanel_appLayout);
        jPanel_appLayout.setHorizontalGroup(
            jPanel_appLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_appLayout.createSequentialGroup()
                .addContainerGap(464, Short.MAX_VALUE)
                .addComponent(jPanel_welcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
        );
        jPanel_appLayout.setVerticalGroup(
            jPanel_appLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_appLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel_welcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_app, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_index, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel_index, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_app, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel_app;
    private javax.swing.JPanel jPanel_head;
    private javax.swing.JPanel jPanel_index;
    private javax.swing.JPanel jPanel_welcome;
    // End of variables declaration//GEN-END:variables
}
