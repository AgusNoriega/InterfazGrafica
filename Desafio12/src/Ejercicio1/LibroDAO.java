/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author agusn
 */


import desafio12.conexion.ConexionPostgres;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

  
    public void insertar(Libro libro) throws SQLException {
        String sql = "INSERT INTO libros (titulo, autor, \"añopublicacion\", isbn, disponible) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setDate(3, Date.valueOf(libro.getAnioPublicacion()));
            ps.setInt(4, libro.getIsbn());
            ps.setBoolean(5, libro.isDisponible());

            ps.executeUpdate();
        }
    }


    public Libro obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM libros WHERE id = ?";
        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        }
        return null;
    }

   
    public List<Libro> listarTodos() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros ORDER BY id";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }


    public void actualizar(Libro libro) throws SQLException {
        String sql = "UPDATE libros SET titulo=?, autor=?, \"añopublicacion\"=?, isbn=?, disponible=? WHERE id=?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setDate(3, Date.valueOf(libro.getAnioPublicacion()));
            ps.setInt(4, libro.getIsbn());
            ps.setBoolean(5, libro.isDisponible());
            ps.setInt(6, libro.getId());

            ps.executeUpdate();
        }
    }

    
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }


    public List<Libro> buscarPorAutor(String autor) throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE autor ILIKE ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + autor + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) lista.add(mapear(rs));
            }
        }
        return lista;
    }


    public List<Libro> listarDisponibles() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE disponible = TRUE";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) lista.add(mapear(rs));
        }
        return lista;
    }


    private Libro mapear(ResultSet rs) throws SQLException {
        return new Libro(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getDate("añopublicacion").toLocalDate(),
                rs.getInt("isbn"),
                rs.getBoolean("disponible")
        );
    }
}
