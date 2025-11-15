/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author agusn
 */


import java.sql.SQLException;
import java.time.LocalDate;

public class MainEjercicio1 {

    public static void main(String[] args) {

        LibroDAO dao = new LibroDAO();

        try {

          
            Libro nuevo = new Libro(
                    "Clean Code",
                    "Robert C. Martin",
                    LocalDate.of(2008, 8, 1),
                    123456,
                    true
            );
            dao.insertar(nuevo);
            System.out.println("Insertado OK");

  
            dao.listarTodos().forEach(System.out::println);

      
            dao.buscarPorAutor("Martin").forEach(System.out::println);

            dao.listarDisponibles().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
