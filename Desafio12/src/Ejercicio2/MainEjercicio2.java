/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author agusn
 */


import java.sql.SQLException;

public class MainEjercicio2 {

    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAO();

        try {
            System.out.println("=== Productos con categoría (JOIN) ===");
            productoDAO.listarConCategoria().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
