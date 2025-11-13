/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author agusn
 */
public class Ejercicio2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ejercicio2.class.getName());


    public Ejercicio2() {
        initComponents();
  
   
    cbNumeros.setModel(new javax.swing.DefaultComboBoxModel<>(
    new String[] {"12","14","16","18","20"}
));
cbNumeros.setSelectedItem("12"); // si querés valor inicial


   
    lblTexto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));


   cbNumeros.addActionListener(e -> {
    int nuevo = Integer.parseInt(cbNumeros.getSelectedItem().toString());
    lblTexto.setFont(lblTexto.getFont().deriveFont((float) nuevo));
});

    }

   
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cbNumeros = new javax.swing.JComboBox<>();
        lblTexto = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbNumeros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero" }));
        jPanel1.add(cbNumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        lblTexto.setText("Texto de Ejemplo");
        jPanel1.add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
   

        java.awt.EventQueue.invokeLater(() -> new Ejercicio2().setVisible(true));
    }

  
    private javax.swing.JComboBox<String> cbNumeros;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTexto;

}
