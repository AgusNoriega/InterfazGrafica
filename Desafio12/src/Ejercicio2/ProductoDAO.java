/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author agusn
 */


import desafio12.conexion.ConexionPostgres;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void insertar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (nombre, precio, stock, categoria_id) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getCategoriaId());
            ps.executeUpdate();
        }
    }

    public void actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE productos SET nombre=?, precio=?, stock=?, categoria_id=? WHERE id=?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getCategoriaId());
            ps.setInt(5, producto.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Producto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("categoria_id")
                    );
                }
            }
        }
        return null;
    }

    public List<Producto> listarTodos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos ORDER BY id";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("categoria_id")
                ));
            }
        }

        return lista;
    }

    public List<Producto> listarConCategoria() throws SQLException {
        List<Producto> lista = new ArrayList<>();

        String sql = """
            SELECT p.id, p.nombre, p.precio, p.stock, p.categoria_id,
                   c.nombre AS categoria_nombre
            FROM productos p
            JOIN categorias c ON p.categoria_id = c.id
            ORDER BY p.id
            """;

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("categoria_id"),
                        rs.getString("categoria_nombre") 
                ));
            }
        }

        return lista;
    }
}
