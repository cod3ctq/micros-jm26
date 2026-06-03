package com.ns_cuenta.dto;


import java.time.LocalDate;

//Mapean los objetos de salida del servicio hacia el cliente
public class TipoCuentaResponse {

    private int tipo;
    private String descripcion;
    private double saldoMin;
    private double saldoMax;
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
