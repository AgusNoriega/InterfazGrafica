/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author agusn
 */
/*
 * DAO para la tabla notas
 */

import desafio12.conexion.ConexionPostgres;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class NotaDAO {


    public void insertar(Nota nota) throws SQLException {
        String sql = "INSERT INTO notas (estudiante_id, materia_id, nota, fecha) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nota.getEstudianteId());
            ps.setInt(2, nota.getMateriaId());
            ps.setDouble(3, nota.getNota());
            ps.setDate(4, Date.valueOf(nota.getFecha()));

            ps.executeUpdate();
        }
    }

 
    public double obtenerPromedioPorEstudiante(int estudianteId) throws SQLException {
        String sql = "SELECT AVG(nota) AS promedio " +
                     "FROM notas " +
                     "WHERE estudiante_id = ?";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, estudianteId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                 
                    double promedio = rs.getDouble("promedio");
                    if (rs.wasNull()) {
                        return 0.0;
                    }
                    return promedio;
                }
            }
        }
        return 0.0;
    }


    public List<Nota> listarHistorialPorEstudiante(int estudianteId) throws SQLException {
        List<Nota> lista = new ArrayList<>();

        String sql = "SELECT * FROM notas " +
                     "WHERE estudiante_id = ? " +
                     "ORDER BY fecha DESC, id";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, estudianteId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }

        return lista;
    }

    public List<Nota> listarPorMateria(int materiaId) throws SQLException {
        List<Nota> lista = new ArrayList<>();

        String sql = "SELECT * FROM notas " +
                     "WHERE materia_id = ? " +
                     "ORDER BY fecha DESC, id";

        try (Connection con = ConexionPostgres.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, materiaId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }

        return lista;
    }


    private Nota mapear(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int estudianteId = rs.getInt("estudiante_id");
        int materiaId = rs.getInt("materia_id");
        double nota = rs.getDouble("nota");
        LocalDate fecha = rs.getDate("fecha").toLocalDate();

        return new Nota(id, estudianteId, materiaId, nota, fecha);
    }
}
