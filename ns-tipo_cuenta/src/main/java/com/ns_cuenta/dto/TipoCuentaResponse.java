package com.ns_cuenta.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

//Se llama Response (respuesta) por que mapean los objetos de salida del servicio hacia el cliente
@Schema(description = "DTO de respuesta con los datos procesado de la cuenta")
public class TipoCuentaResponse {

    @Schema(description = "Descripcion del numero de cuenta", example = "1")
    private int tipo;

    @Schema(description = "Descripcion del tipo de cuenta", example = "AHORRO BASICA")
    private String descripcion;

    @Schema(description = "Saldo minimo de la cuenta", example = "1000")
    private double saldoMin;

    @Schema(description = "Saldo maximo de la cuenta", example = "1000")
    private double saldoMax;

    @Schema(description = "Fecha del guardado de la cuenta", example = "02/06/2026")
    private LocalDate fechaRegistro;


    public TipoCuentaResponse(int tipo, String descripcion, double saldoMin, double saldoMax, LocalDate fechaRegistro) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
        this.fechaRegistro = fechaRegistro;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "TipoCuentaResponse{" +
                "tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
