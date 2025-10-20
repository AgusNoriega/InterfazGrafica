/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConversorControlador;
import Vista.Vista;
import Conversor.Conversor;
import javax.swing.JOptionPane;
/**
 *
 * @author Alumno
 */
public class ConversorControlador {
     private Conversor modelo;
    private Vista vista;

    public ConversorControlador(Conversor modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.btnConvertir.addActionListener(e -> convertir());
    }

    private void convertir() {
        try {
            double valor = Double.parseDouble(vista.txtEntrada.getText());
            String tipo = (String) vista.cmbConversion.getSelectedItem();
            double resultado;

            if (tipo.equals("Celsius a Fahrenheit")) {
                resultado = modelo.celsiusAFahrenheit(valor);
            } else {
                resultado = modelo.fahrenheitACelsius(valor);
            }

            vista.txtResultado.setText(String.format("%.2f", resultado));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

