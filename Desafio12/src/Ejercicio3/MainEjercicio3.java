/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author agusn
 */


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MainEjercicio3 {

    public static void main(String[] args) {

        NotaDAO dao = new NotaDAO();

        try {
            
            Nota n1 = new Nota(1, 2, 8.5, LocalDate.of(2024, 11, 1));
            Nota n2 = new Nota(1, 2, 7.0, LocalDate.of(2024, 11, 15));
            Nota n3 = new Nota(1, 3, 9.0, LocalDate.of(2024, 11, 20));

            dao.insertar(n1);
            dao.insertar(n2);
            dao.insertar(n3);

            System.out.println("Notas insertadas correctamente.");

         
            double promedio = dao.obtenerPromedioPorEstudiante(1);
            System.out.println("Promedio del estudiante 1: " + promedio);

 
            System.out.println("Historial de notas del estudiante 1:");
            List<Nota> historial = dao.listarHistorialPorEstudiante(1);
            historial.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
