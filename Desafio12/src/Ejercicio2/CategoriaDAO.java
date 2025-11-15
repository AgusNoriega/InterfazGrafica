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

public class CategoriaDAO {

    public void insertar(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
        }
    }

    public void actualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categorias SET nombre = ? WHERE id = ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM categorias WHERE id = ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categorias WHERE id = ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Categoria(rs.getInt("id"), rs.getString("nombre"));
                }
            }
        }
        return null;
    }

    public List<Categoria> listarTodas() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias ORDER BY id";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Categoria(rs.getInt("id"), rs.getString("nombre")));
            }
        }
        return lista;
    }
}
