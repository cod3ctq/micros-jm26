package com.ms_empleados.dto;

import java.time.LocalDate;

// Clase que mapea los Objetos de salida del servicio hacia el cliente, sólo lo que queramos mostrar de regreso
public class EmpleadoResponse {
    // Atributos
    private String nombre;
    private String apP;
    private String apM;
    private LocalDate fechaIn;

    // Constructor
    public EmpleadoResponse(String nombre, String apP, String apM, LocalDate fechaIn) {
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.fechaIn = fechaIn;
    }

    // Getters / Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApP() {
        return apP;
    }
    public void setApP(String apP) {
        this.apP = apP;
    }
    public String getApM() {
        return apM;
    }
    public void setApM(String apM) {
        this.apM = apM;
    }
    public LocalDate getFechaIn() {
        return fechaIn;
    }
    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "EmpleadoResponse{" +
                "nombre='" + nombre + '\'' +
                ", apP='" + apP + '\'' +
                ", apM='" + apM + '\'' +
                ", fechaIn=" + fechaIn +
                '}';
    }
}