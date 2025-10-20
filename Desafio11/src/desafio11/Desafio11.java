/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafio11;

import Vista.Vista;
import ConversorControlador.ConversorControlador;
import Conversor.Conversor;

/**
 *
 * @author Alumno
 */
public class Desafio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Conversor modelo = new Conversor();
        Vista vista = new Vista();
        new ConversorControlador(modelo, vista);
        vista.setVisible(true);
    }
    
}
