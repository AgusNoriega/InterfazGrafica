/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author agusn
 */



import java.time.LocalDate;

public class Nota {

    private int id;
    private int estudianteId;
    private int materiaId;
    private double nota;
    private LocalDate fecha;


    public Nota(int estudianteId, int materiaId, double nota, LocalDate fecha) {
        this.estudianteId = estudianteId;
        this.materiaId = materiaId;
        this.nota = nota;
        this.fecha = fecha;
    }

    public Nota(int id, int estudianteId, int materiaId, double nota, LocalDate fecha) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.materiaId = materiaId;
        this.nota = nota;
        this.fecha = fecha;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEstudianteId() { return estudianteId; }
    public void setEstudianteId(int estudianteId) { this.estudianteId = estudianteId; }

    public int getMateriaId() { return materiaId; }
    public void setMateriaId(int materiaId) { this.materiaId = materiaId; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", estudianteId=" + estudianteId +
                ", materiaId=" + materiaId +
                ", nota=" + nota +
                ", fecha=" + fecha +
                '}';
    }
}
