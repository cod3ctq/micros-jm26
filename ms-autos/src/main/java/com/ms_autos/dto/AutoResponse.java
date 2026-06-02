package com.ms_autos.dto;

import java.time.LocalDate;

//Se llama Response (Respuesta) por que apean los objetos de salida del servicio hacia el cliente
public class AutoResponse {

    private String modelo;
    private int año;
    private String tipo;
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
