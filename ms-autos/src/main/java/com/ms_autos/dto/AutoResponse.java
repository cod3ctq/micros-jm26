package com.ms_autos.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

//Se llama Response (Respuesta) por que mapean los objetos de salida del servicio hacia el cliente
@Schema(description = "DTO de respuesta con los datos procesados del auto")
public class AutoResponse {

    @Schema(description = "Descripcion del modelo del auto", example = "Camaro LS")
    private String modelo;

    @Schema(description = "Año del auto", example = "2020")
    private int año;

    @Schema(description = "Tipo del auto", example = "Muscle Car")
    private String tipo;

    @Schema(description = "Fecha del guardado del auto", example = "01/01/2022")
    private LocalDate fechaRegistro;

    public AutoResponse(String modelo, int año, String tipo, LocalDate fechaRegistro) {
        this.modelo = modelo;
        this.año = año;
        this.tipo = tipo;
        this.fechaRegistro = fechaRegistro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "AutoResponse{" +
                "modelo='" + modelo + '\'' +
                ", año=" + año +
                ", tipo='" + tipo + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
