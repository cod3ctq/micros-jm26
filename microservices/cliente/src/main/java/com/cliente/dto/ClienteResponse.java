package com.cliente.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

//Mapean los objetos de salida del servicio hacia el cliente
@Schema(description = "DTO de respuesta con los datos procesados del cliente")
public class ClienteResponse {

    @Schema(description = "Nombre del cliente", example = "Carlos")
    private String nombre;
    @Schema(description = "Apellido paterno del cliente", example = "Sanchez")
    private String apP;
    @Schema(description = "Apellido materno del cliente", example = "Ramirez")
    private String apM;
    @Schema(description = "Fecha de nacimiento del cliente", example = "28-03-2000")
    private LocalDate fechaNac;

    public ClienteResponse(String nombre, String apP, String apM, LocalDate fechaNac) {
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.fechaNac = fechaNac;
    }

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

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}
