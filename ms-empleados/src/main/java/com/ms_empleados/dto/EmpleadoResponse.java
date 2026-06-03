package com.ms_empleados.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

// Clase que mapea los Objetos de salida del servicio hacia el cliente, sólo lo que queramos mostrar de regreso
// Se llama Response (respuesta) porque porque mapean los Objetos de salida del Servicio hacia el cliente
@Schema(description = "DTO de respuesta con los datos procesados del empleado") // Se utiliza para documentar modelos (DTOs, Entities o Responses) en Swagger UI
public class EmpleadoResponse {
    // Atributos
    @Schema(description = "Nombre del empleado", example = "CARLOS")
    private String nombre;
    @Schema(description = "Apellido paterno del empleado", example = "ORTIZ")
    private String apP;
    @Schema(description = "Apellido materno del empleado", example = "CORNEJO")
    private String apM;
    @Schema(description = "Fecha de ingreso del empleado", example = "01/01/2023")
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