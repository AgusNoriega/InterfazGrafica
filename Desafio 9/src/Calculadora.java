/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import java.awt.Button; 





public class Calculadora extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Calculadora.class.getName());

  private BigDecimal acumulado = BigDecimal.ZERO;   
private String operadorPendiente = null;        
private boolean limpiarEntrada = true;            
private StringBuilder entrada = new StringBuilder(); 
    public Calculadora() {
        initComponents();
        setupCalculadora();
    }
private void setupCalculadora() {

    lblResultado.setText("0");

   
   Button[] digitos = { btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9 };
for (int d = 0; d <= 9; d++) {
    final int dd = d;
    if (digitos[d] != null) digitos[d].addActionListener(e -> onDigit(dd));
}


    // mapear operadores
    if (btnSumar != null)       btnSumar.addActionListener(e -> onOperator("+"));
    if (btnRestar != null)      btnRestar.addActionListener(e -> onOperator("-"));
    if (btnMultiplicar != null) btnMultiplicar.addActionListener(e -> onOperator("×"));
    if (btnDividir != null)     btnDividir.addActionListener(e -> onOperator("÷"));
}


private void onDigit(int d) {
    if (limpiarEntrada) {
        entrada.setLength(0);
        limpiarEntrada = false;
    }
   
    if (entrada.length() == 1 && entrada.charAt(0) == '0') {
        entrada.setCharAt(0, (char) ('0' + d));
    } else {
        entrada.append(d);
    }
    lblResultado.setText(entrada.toString());
}

private void onOperator(String op) {
  
    BigDecimal actual = leerPantalla();

    if (operadorPendiente == null) {
        acumulado = actual;
    } else if (!limpiarEntrada) {
        acumulado = calcular(acumulado, actual, operadorPendiente);
    }
 
    lblResultado.setText(format(acumulado));

   
    operadorPendiente = op;
    limpiarEntrada = true;
}


private BigDecimal calcular(BigDecimal a, BigDecimal b, String op) {
    switch (op) {
        case "+": return a.add(b);
        case "-": return a.subtract(b);
        case "×": return a.multiply(b);
        case "÷":
            if (b.compareTo(BigDecimal.ZERO) == 0) {
                lblResultado.setText("Error");
                limpiarEntrada = true;
                operadorPendiente = null;
                return a; // no cambia acumulado
            }
            return a.divide(b, 10, RoundingMode.HALF_UP).stripTrailingZeros();
        default: throw new IllegalArgumentException("Operador desconocido: " + op);
    }
}
private BigDecimal leerPantalla() {
    String t = lblResultado.getText();
    // si hay entrada nueva, usamos esa; si no, usamos lo visible
    String s = (entrada.length() > 0 && !limpiarEntrada) ? entrada.toString() : t;
    if (s.equals("Error") || s.isEmpty()) s = "0";
    return new BigDecimal(s);
}

private String format(BigDecimal v) {
    String s = v.stripTrailingZeros().toPlainString();
    if (s.equals("-0")) s = "0";
    return s;
}

    @SuppressWarnings("unchecked")
  
    private void initComponents() {

        button2 = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        btnDividir = new java.awt.Button();
        panel2 = new java.awt.Panel();
        btnSumar = new java.awt.Button();
        button4 = new java.awt.Button();
        btnRestar = new java.awt.Button();
        btn0 = new java.awt.Button();
        btnMultiplicar = new java.awt.Button();
        btn3 = new java.awt.Button();
        btn6 = new java.awt.Button();
        btn9 = new java.awt.Button();
        btn2 = new java.awt.Button();
        btn5 = new java.awt.Button();
        btn8 = new java.awt.Button();
        btn1 = new java.awt.Button();
        btn4 = new java.awt.Button();
        btn7 = new java.awt.Button();
        lblResultado = new java.awt.Label();

        button2.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, -1, -1));

        btnDividir.setLabel("/");
        btnDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDividirActionPerformed(evt);
            }
        });
        jPanel2.add(btnDividir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 400, -1));

        btnSumar.setLabel("+");
        btnSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        button4.setLabel("+");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel2.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        btnRestar.setLabel("-");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        btn0.setLabel("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel2.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        btnMultiplicar.setLabel("*");
        btnMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicarActionPerformed(evt);
            }
        });
        jPanel2.add(btnMultiplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        btn3.setActionCommand("3");
        btn3.setLabel("3");
        btn3.setName(""); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        btn6.setLabel("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        btn9.setLabel("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        btn2.setLabel("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        btn5.setLabel("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        btn8.setLabel("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btn1.setLabel("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        btn4.setLabel("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        btn7.setLabel("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        lblResultado.setText("Resultado");
        jPanel2.add(lblResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDividirActionPerformed
       
    }//GEN-LAST:event_btnDividirActionPerformed

    private void btnSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarActionPerformed
      
    }//GEN-LAST:event_btnSumarActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        
    }//GEN-LAST:event_button4ActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
   
    }//GEN-LAST:event_btnRestarActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
       
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicarActionPerformed
    
    }//GEN-LAST:event_btnMultiplicarActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
      
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
  
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
      
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
   
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
       
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
       
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
       
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
       
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
     
    }//GEN-LAST:event_btn7ActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Calculadora().setVisible(true));
    }

    
    private java.awt.Button btn0;
    private java.awt.Button btn1;
    private java.awt.Button btn2;
    private java.awt.Button btn3;
    private java.awt.Button btn4;
    private java.awt.Button btn5;
    private java.awt.Button btn6;
    private java.awt.Button btn7;
    private java.awt.Button btn8;
    private java.awt.Button btn9;
    private java.awt.Button btnDividir;
    private java.awt.Button btnMultiplicar;
    private java.awt.Button btnRestar;
    private java.awt.Button btnSumar;
    private java.awt.Button button2;
    private java.awt.Button button4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label lblResultado;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;

}
