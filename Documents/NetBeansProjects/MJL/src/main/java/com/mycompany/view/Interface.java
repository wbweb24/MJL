package com.mycompany.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

 

public class Interface extends javax.swing.JFrame {
    
    private int newIndex;

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
    
    public void generateButtons(int num) {
    jPanel_index.setLayout(new BoxLayout(jPanel_index, BoxLayout.Y_AXIS)); // Organización vertical

    int panelWidth = jPanel_index.getWidth();
    int buttonWidth = (int) (panelWidth * 0.60); // Botón ocupará el 60% del panel

    for (int i = 1; i <= num; i++) {
        JButton button = new JButton("Reto " + i);
        button.setPreferredSize(new Dimension(buttonWidth, 40)); // Tamaño del botón
        button.setMaximumSize(new Dimension(buttonWidth, 40)); // Evita que se expanda más
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrado en el panel
        
        button.addActionListener(e -> {
            newIndex = Integer.parseInt(button.getText().replaceAll("\\D", "")) - 1;
            firePropertyChange("newIndexChanged", false, true);
        });
      /*********************************************************************************REVISAR CIMENSIONS*/
        jPanel_index.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_index.add(new Box.Filler(
        new Dimension(0, 5),  // Tamaño mínimo
        new Dimension(0, 10),  // Tamaño preferido
        new Dimension(0, 20)   // Tamaño máximo
        ));
        
        jPanel_index.add(button);
    }
    
    
}
    
    public int getNewIndex() {
    return newIndex;
}
    
    public void executeMiniApp() {
    
    jPanel_app.removeAll();
    jPanel_app.setLayout(new BorderLayout());

   /* --------------- SECCIÓN SUPERIOR: TÍTULO Y ÁREA DE VISUALIZACIÓN --------------- */
    /*JLabel titleLabel = new JLabel("Valores añadidos al Arreglo:");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
    titleLabel.setForeground(new Color(255, 140, 0)); */

    
    JLabel valuesDisplay = new JLabel();
    valuesDisplay.setFont(new Font("Arial", Font.BOLD, 22)); 
    valuesDisplay.setForeground(new Color(255, 140, 0)); 
    
    JLabel limitLabel = new JLabel("Introduzca la cantidad límite:");
    limitLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
    limitLabel.setForeground(new Color(255, 140, 0)); 
    
    JTextField limitField = new JTextField(6);

    JLabel filterLabel = new JLabel("Seleccione muestra:");
    filterLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
    filterLabel.setForeground(new Color(255, 140, 0)); 
    
    String[] filterOptions = {"Todos", "Superiores", "Superiores e Iguales", "Iguales", "Iguales e Inferiores", "Inferiores"};
    JComboBox<String> conditionDropdown = new JComboBox<>(filterOptions);
    conditionDropdown.setForeground(new Color(255, 140, 0));
    
    
    
    JButton resultBtn = new JButton("Mostrar");
    JLabel resultLabel = new JLabel();
    
    
    JPanel valuesPanel = new JPanel();
    valuesPanel.setLayout(new BoxLayout(valuesPanel, BoxLayout.Y_AXIS));
    valuesPanel.setOpaque(false);
    
    
    JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    titlePanel.setOpaque(false);
    JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    filterPanel.setOpaque(false);
    JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    resultPanel.setOpaque(false);
    
    /*titlePanel.add(titleLabel);*/
    titlePanel.add(valuesDisplay);

    filterPanel.add(limitLabel);
    filterPanel.add(limitField);
    filterPanel.add(filterLabel);
    filterPanel.add(conditionDropdown);

    resultPanel.add(resultBtn);
    resultPanel.add(resultLabel);
    
    
    valuesPanel.add(titlePanel);
    valuesPanel.add(filterPanel);
    valuesPanel.add(resultPanel);
    
    
    
    
    
    

    /* --------------- SECCIÓN CENTRAL: CAMPOS DE ENTRADA DE DATOS --------------- */
    JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
    inputPanel.setOpaque(false);

    JPanel iPLeft = new JPanel();
    iPLeft.setPreferredSize(new Dimension(50, 100));
    iPLeft.setOpaque(false);

    JPanel iPRight = new JPanel();
    iPRight.setPreferredSize(new Dimension(50, 100));
    iPRight.setOpaque(false);




    inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Intenta centrarlo dentro del layout

    // Declaración del array de ventas
    double[] sales = new double[8]; 

// Panel de entrada con disposición más eficiente

// Creación de los componentes dentro del bucle
    for (int i = 0; i < sales.length; i++) {
        sales[i] = 0.00; // Inicializamos cada posición con 0.00

        // Se crea una etiqueta con el número de la venta
        JLabel salesLabel = new JLabel("Venta " + (i + 1) + ":");
        salesLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Se crea el campo de texto con el valor inicial
        JTextField salesField = new JTextField(String.format("%.2f", sales[i]), 12);

        // Se crea la etiqueta del símbolo de moneda
        JLabel euroLabel = new JLabel("€");

        // Se agregan los elementos al panel de entrada
        inputPanel.add(salesLabel);
        inputPanel.add(salesField);
        inputPanel.add(euroLabel);
    }





    /* --------------- SECCIÓN INFERIOR: BOTONES DE ACCIÓN --------------- */
    JPanel panelButtons = new JPanel();
    panelButtons.setOpaque(false);
    panelButtons.setPreferredSize(new Dimension(valuesPanel.getWidth(), 70));
    JButton submitBtn = new JButton("Enviar");
    JButton clearBtn = new JButton("Reiniciar");
    JButton randomBtn = new JButton("Valores aleatorios");
    panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); // Centra los botones


    panelButtons.add(submitBtn);
    panelButtons.add(clearBtn);
    panelButtons.add(randomBtn);

    /* --------------- FUNCIONALIDAD DE LOS BOTONES DE ACCIÓN ---------------*/
    submitBtn.addActionListener(e -> {
        
        for (int i = 0; i < sales.length; i++) {
          
            sales[i] = Double.parseDouble(((JTextField) inputPanel.getComponent(i * 3 + 1)).getText());
        }
    
    
    
    });

    clearBtn.addActionListener(e -> {
        for (int i = 0; i < sales.length; i++) {
            sales[i] = 0.00;
            ((JTextField) inputPanel.getComponent(i * 3+1)).setText("0,00");
        }
            /*valuesDisplay.setText("[]");   DECIDIR
            Como cada fila tiene tres componentes, para acceder a los JTextField, necesitamos calcular su índice en el GridLayout:

En la primera fila (i = 0), el JTextField está en el índice 0 * 3 + 1 = 1.

En la segunda fila (i = 1), el JTextField está en el índice 1 * 3 + 1 = 4.

En la tercera fila (i = 2), el JTextField está en el índice 2 * 3 + 1 = 7.
        
    });

    randomBtn.addActionListener(e -> {
        Random rand = new Random();
        for (int i = 0; i < sales.length; i++) {
            if (sales[i].getText().isEmpty() || sales[i].getText(equals(0,)) {
                sales[i].setText(String.valueOf(rand.nextInt(5000)));
            }
        }*/
    
    });
    
    /* --------------- FUNCIONALIDAD DEl BOTÓN DE RESULTADO --------------- */
    resultBtn.addActionListener(e -> {
    String input = limitField.getText().trim();
    if (!input.matches("\\d+(\\.\\d+)?")) {
        resultLabel.setText("Introduce una cantidad válida.");
        return;
    }

    double limit = Double.parseDouble(input);
    String condition = (String) conditionDropdown.getSelectedItem();
    StringBuilder filteredSales = new StringBuilder("<html>");

    for (int i = 0; i < sales.length; i++) {
        boolean matchesCondition = switch (condition) {
            case "Superiores" -> sales[i] > limit;
            case "Superiores e Iguales" -> sales[i] >= limit;
            case "Iguales" -> sales[i] == limit;
            case "Iguales e Inferiores" -> sales[i] <= limit;
            case "Inferiores" -> sales[i] < limit;
            default -> false;
        };

        if (matchesCondition) {
            filteredSales.append("Venta ").append(i + 1).append(": ").append(sales[i]).append("<br>");
        }
    }

    filteredSales.append("</html>");
    resultLabel.setText(filteredSales.toString());
});

    
    
    

    // Agregar todo a `jPanel_app`
    jPanel_app.add(valuesPanel, BorderLayout.NORTH);    
    jPanel_app.add(inputPanel, BorderLayout.CENTER);
    jPanel_app.add(iPLeft, BorderLayout.WEST);
    jPanel_app.add(iPRight, BorderLayout.EAST);
    jPanel_app.add(panelButtons, BorderLayout.SOUTH);

    /* Refrescar la vista
    jPanel_app.revalidate();
    jPanel_app.repaint();*/
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
