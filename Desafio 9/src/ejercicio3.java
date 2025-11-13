/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author agusn
 */
public class ejercicio3 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ejercicio3.class.getName());
    
  private final Map<String,String> info = new HashMap<>();
private final DefaultListModel<String> modelo = new DefaultListModel<>();


   public ejercicio3() {
    initComponents();
    setTitle("Lenguajes de Programación");
    setLocationRelativeTo(null);

    DefaultListModel<String> modelo = new DefaultListModel<>();
    String[] lenguajes = {"Java","Python","C++","JavaScript","C#","Go","Ruby","Kotlin","Swift","PHP"};
    for (String l : lenguajes) modelo.addElement(l);
    jList1.setModel(modelo);
    jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);


    java.util.Map<String,String> info = new java.util.HashMap<>();
    info.put("Java","Java: orientado a objetos, JVM, backend, Android.");



    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override public void mouseClicked(java.awt.event.MouseEvent e) {
            if (e.getClickCount() == 2) {
                int i = jList1.locationToIndex(e.getPoint());
                if (i >= 0) {
                    String lang = jList1.getModel().getElementAt(i);
                    String msg = info.getOrDefault(lang, "Sin información disponible.");
                    javax.swing.JOptionPane.showMessageDialog(ejercicio3.this, msg, lang,
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    });
}
}

    
     
    
   
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lstNombres = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstNombres.setViewportView(jList1);

        jPanel1.add(lstNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            java.awt.EventQueue.invokeLater(() -> {
        ejercicio3 frame = new ejercicio3();
        frame.setVisible(true);
    });
    }


    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane lstNombres;
   

